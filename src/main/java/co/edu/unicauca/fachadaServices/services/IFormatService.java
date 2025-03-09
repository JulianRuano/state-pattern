package co.edu.unicauca.fachadaServices.services;

import java.util.Collection;

import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;
import co.edu.unicauca.fachadaServices.DTO.response.ResponseDto;

public interface IFormatService {

    public ResponseDto<FormatDTOResponse> createFormat(FormatDTORequest format);
    public ResponseDto<FormatDTOResponse> updateFormat(Integer id, FormatDTORequest format);
    public ResponseDto<FormatDTOResponse> getFormat(Integer id);
    public void deleteFormat(Integer id);
    public ResponseDto<Collection<FormatDTOResponse>> getFormatByDateRange(String startDate, String endDate);

    public ResponseDto<String> changeState(Integer id, String state);
}
