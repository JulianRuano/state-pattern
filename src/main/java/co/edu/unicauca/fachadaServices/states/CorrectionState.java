package co.edu.unicauca.fachadaServices.states;

import java.util.Optional;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;

public class CorrectionState implements StatesInt {

    private final FormatRepository repository;

    public CorrectionState(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result sendForEvaluation(FormatDTORequest format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("evaluation");
        repository.update(formatEntity.get());
        return new Result(true, "El formato ha sido enviado para evaluación");
    }

    @Override
    public Result approveFormat(FormatDTORequest format) {
        return new Result(false, "El formato no puede ser aprobado en estado de corrección");
    }

    @Override
    public Result rejectFormat(FormatDTORequest format) {
        return new Result(false, "El formato no puede ser rechazado en estado de corrección");
    }

    @Override
    public Result sendForCorrection(FormatDTORequest format) {
        return new Result(false, "El formato ya ha sido enviado para corrección");
    }
    
}
