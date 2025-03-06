package co.edu.unicauca.fachadaServices.states;

import java.util.Optional;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public class CorrectionState implements StatesInt {

    private final FormatRepository repository;

    public CorrectionState(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result sendForEvaluation(FormatDTO format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setStateEntity("evaluation");
        repository.save(formatEntity.get());
        return new Result(true, "El formato ha sido enviado para evaluación");
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        return new Result(false, "El formato no puede ser aprobado en estado de revisión");
    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        return new Result(false, "El formato no puede ser rechazado en estado de revisión");
    }

    @Override
    public Result sendForCorrection(FormatDTO format) {
        return new Result(false, "El formato ya ha sido enviado para revisión");
    }
    
}
