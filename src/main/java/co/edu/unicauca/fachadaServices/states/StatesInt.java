package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public interface StatesInt {
    Result sendForEvaluation(FormatDTO format);
    Result approveFormat(FormatDTO format);
    Result rejectFormat(FormatDTO format);
    Result sendForRevision(FormatDTO format);
}
