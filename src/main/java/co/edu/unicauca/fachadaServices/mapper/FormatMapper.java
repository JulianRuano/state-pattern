package co.edu.unicauca.fachadaServices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;
import co.edu.unicauca.capaAccesoDatos.models.FormatPPEntity;
import co.edu.unicauca.capaAccesoDatos.models.FormatTIEntity;
import co.edu.unicauca.fachadaServices.DTO.request.FormatDTORequest;
import co.edu.unicauca.fachadaServices.DTO.request.FormatPPDTORequest;
import co.edu.unicauca.fachadaServices.DTO.request.FormatTIDTORequest;
import co.edu.unicauca.fachadaServices.DTO.response.FormatDTOResponse;
import co.edu.unicauca.fachadaServices.DTO.response.FormatPPDTOResponse;
import co.edu.unicauca.fachadaServices.DTO.response.FormatTIDTOResponse;

@Mapper(componentModel = "spring")
public interface FormatMapper {
    
    @SubclassMapping(source = FormatPPEntity.class, target = FormatPPDTOResponse.class)
    @SubclassMapping(source = FormatTIEntity.class, target = FormatTIDTOResponse.class)
    FormatDTOResponse toFormatDTOResponse(FormatEntity formatEntity);


    @SubclassMapping(source = FormatPPDTOResponse.class, target = FormatPPEntity.class)
    @SubclassMapping(source = FormatTIDTOResponse.class, target = FormatTIEntity.class)
    FormatEntity toFormatEntity(FormatDTOResponse formatDTO);


    @SubclassMapping(source = FormatPPEntity.class, target = FormatPPDTORequest.class)
    @SubclassMapping(source = FormatTIEntity.class, target = FormatTIDTORequest.class)
    FormatDTORequest toFormatDTORequest(FormatEntity formatEntity);
    

    @SubclassMapping(source = FormatPPDTORequest.class, target = FormatPPEntity.class)
    @SubclassMapping(source = FormatTIDTORequest.class, target = FormatTIEntity.class)
    FormatEntity toFormatEntity(FormatDTORequest formatDTO);
}
