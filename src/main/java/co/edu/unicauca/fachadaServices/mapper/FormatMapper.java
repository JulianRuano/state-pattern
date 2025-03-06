package co.edu.unicauca.fachadaServices.mapper;

import org.mapstruct.Mapper;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;

@Mapper(componentModel = "spring")
public interface FormatMapper {
    
    FormatDTO toFormatDTO(FormatEntity formatEntity);

    FormatEntity toFormatEntity(FormatDTO formatDTO);
}
