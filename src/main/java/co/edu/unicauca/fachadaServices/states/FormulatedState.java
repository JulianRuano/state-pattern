package co.edu.unicauca.fachadaServices.states;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.repositories.FormatRepository;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

@Service
public class FormulatedState implements StatesInt {

    private final FormatRepository repository;

    public FormulatedState(FormatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result sendForEvaluation(FormatDTO format) {
        Optional<FormatEntity> formatEntity = repository.findById(format.getId());
        formatEntity.get().setState("evaluation");
        repository.save(formatEntity.get());
        return new Result(true, "El formato ha sido enviado para evaluación");
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        return new Result(false, "El formato no puede ser aprobado en estado de formulación");
    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        return new Result(false, "El formato no puede ser rechazado en estado de formulación");
    }

    @Override
    public Result sendForCorrection(FormatDTO format) {
        return new Result(false, "El formato no puede ser enviado para revisión en estado de formulación");
    }
    
}
