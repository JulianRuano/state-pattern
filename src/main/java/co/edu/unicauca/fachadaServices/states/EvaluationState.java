package co.edu.unicauca.fachadaServices.states;

import java.util.Optional;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;

public class EvaluationState implements StatesInt{

    private final FormatRepository repository;

    public EvaluationState(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result sendForEvaluation(FormatDTORequest format) {
        return new Result(false, "El formato ya se encuentra en estado de Evaluación");
    }

    @Override
    public Result approveFormat(FormatDTORequest format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("approved");
        repository.update(formatEntity.get());
        return new Result(true, "El formato ha sido aprobado");
    }

    @Override
    public Result rejectFormat(FormatDTORequest format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("rejected");
        repository.update(formatEntity.get());
        return new Result(true, "El formato ha sido rechazado");

    }

    @Override
    public Result sendForCorrection(FormatDTORequest format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("correction");
        repository.update(formatEntity.get());
        return new Result(true, "El formato ha sido enviado a revisión");
    }
}
