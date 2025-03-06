package co.edu.unicauca.fachadaServices.states;

import org.springframework.stereotype.Service;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

@Service
public class EvaluationState implements StatesInt{
    @Override
    public Result sendForEvaluation(FormatDTO format) {
        return new Result(false, "El formato ya se encuentra en estado de Evaluación");
        
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        return new Result(true, "El formato ha sido aprobado");

    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        return new Result(true, "El formato ha sido rechazado");

    }

    @Override
    public Result sendForCorrection(FormatDTO format) {
        return new Result(true, "El formato ha sido enviado a revisión");
    }
}
