package co.edu.unicauca.fachadaServices.services;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

public interface IFormatService {

    public FormatDTO createFormat(FormatDTO format);
    public FormatDTO updateFormat(Integer id, FormatDTO format);
    public FormatDTO getFormat(Integer id);
    public void deleteFormat(Integer id);
    public FormatDTO findAllFormatDTO();

    public String changeState(Integer id, String state);
}
