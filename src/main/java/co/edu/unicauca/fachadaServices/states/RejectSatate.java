package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public class RejectSatate implements StatesInt {

    @Override
    public Result sendForEvaluation(FormatDTO format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");
        
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");

    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");

    }

    @Override
    public Result sendForCorrection(FormatDTO format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");
    }
    
}
