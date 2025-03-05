package co.edu.unicauca.fachadaServices.states;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;

public interface StatesInt {
    Result sendForEvaluation(FormatEntity format);
    Result approveFormat(FormatEntity format);
    Result rejectFormat(FormatEntity format);
    Result sendForRevision(FormatEntity format);
}
