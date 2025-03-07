package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;

public interface StatesInt {
    Result sendForEvaluation(FormatDTORequest format);
    Result approveFormat(FormatDTORequest format);
    Result rejectFormat(FormatDTORequest format);
    Result sendForCorrection(FormatDTORequest format);
}
