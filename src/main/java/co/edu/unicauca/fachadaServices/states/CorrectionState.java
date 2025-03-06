package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CorrectionState implements StatesInt {


    @Override
    public Result sendForEvaluation(FormatDTO format) {
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
