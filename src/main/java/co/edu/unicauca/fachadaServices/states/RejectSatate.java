package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;

public class RejectSatate implements StatesInt {

    @Override
    public Result sendForEvaluation(FormatDTORequest format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");
        
    }

    @Override
    public Result approveFormat(FormatDTORequest format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");

    }

    @Override
    public Result rejectFormat(FormatDTORequest format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");

    }

    @Override
    public Result sendForCorrection(FormatDTORequest format) {
        return new Result(false, "No se puede cambiar el estado de un formato Rechazado");
    }
    
}
