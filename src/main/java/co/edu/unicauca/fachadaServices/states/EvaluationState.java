package co.edu.unicauca.fachadaServices.states;

import java.util.Optional;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public class EvaluationState implements StatesInt{

    private final FormatRepository repository;

    public EvaluationState(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result sendForEvaluation(FormatDTO format) {
        return new Result(false, "El formato ya se encuentra en estado de Evaluación");
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("approved");
        repository.save(formatEntity.get());
        return new Result(true, "El formato ha sido aprobado");
    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("rejected");
        repository.save(formatEntity.get());
        return new Result(true, "El formato ha sido rechazado");

    }

    @Override
    public Result sendForCorrection(FormatDTO format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("correction");
        repository.save(formatEntity.get());
        return new Result(true, "El formato ha sido enviado a revisión");
    }
}
