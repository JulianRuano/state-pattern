package co.edu.unicauca.fachadaServices.services;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import co.edu.unicauca.fachadaServices.states.Result;
import co.edu.unicauca.fachadaServices.states.StatesInt;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateServices  {

    private StatesInt state;

    public StateServices(StatesInt state) {
        this.state = state;
    }

    public Result sendForEvaluation(FormatDTO format) {
        return state.sendForEvaluation(format);
    }

    public Result approveFormat(FormatDTO format) {
        return state.approveFormat(format);
    }

    public Result rejectFormat(FormatDTO format) {
        return state.rejectFormat(format);
    }

    public Result sendForRevision(FormatDTO format) {
        return state.sendForRevision(format);
    }
}
