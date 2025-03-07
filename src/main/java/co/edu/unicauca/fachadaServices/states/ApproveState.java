package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;

public class ApproveState implements StatesInt {

    @Override
    public Result sendForEvaluation(FormatDTORequest format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result approveFormat(FormatDTORequest format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result rejectFormat(FormatDTORequest format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result sendForCorrection(FormatDTORequest format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }


}
