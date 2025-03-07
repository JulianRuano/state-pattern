package co.edu.unicauca.fachadaServices.services;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;

public interface IFormatService {

    public FormatDTOResponse createFormat(FormatDTORequest format);
    public FormatDTOResponse updateFormat(Integer id, FormatDTORequest format);
    public FormatDTOResponse getFormat(Integer id);
    public void deleteFormat(Integer id);
    public FormatDTOResponse findAllFormatDTO();

    public String changeState(Integer id, String state);
}
