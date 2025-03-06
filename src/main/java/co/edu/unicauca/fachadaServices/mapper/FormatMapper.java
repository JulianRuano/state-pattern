package co.edu.unicauca.fachadaServices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.models.FormatPPEntity;
import co.edu.unicauca.capaAccesoDatos.models.FormatTIEntity;
import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import co.edu.unicauca.fachadaServices.DTO.response.FormatPPDTOResponse;
import co.edu.unicauca.fachadaServices.DTO.response.FormatTIDTOResponse;

@Mapper(componentModel = "spring")
public interface FormatMapper {
    
    @SubclassMapping(source = FormatPPEntity.class, target = FormatPPDTOResponse.class)
    @SubclassMapping(source = FormatTIEntity.class, target = FormatTIDTOResponse.class)
    FormatDTO toFormatDTO(FormatEntity formatEntity);

    @SubclassMapping(source = FormatPPDTOResponse.class, target = FormatPPEntity.class)
    @SubclassMapping(source = FormatTIDTOResponse.class, target = FormatTIEntity.class)
    FormatEntity toFormatEntity(FormatDTO formatDTO);
}
