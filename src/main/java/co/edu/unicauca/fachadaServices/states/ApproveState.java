package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public class ApproveState implements StatesInt {

    @Override
    public Result sendForEvaluation(FormatDTO format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result approveFormat(FormatDTO format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result rejectFormat(FormatDTO format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Result sendForRevision(FormatDTO format) {
        return new Result(false, "El formato ya ha sido aprobado");
    }


}
