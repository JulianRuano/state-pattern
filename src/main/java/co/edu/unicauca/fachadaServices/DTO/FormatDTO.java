package co.edu.unicauca.fachadaServices.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import co.edu.unicauca.fachadaServices.DTO.request.FormatPPDTORequest;
import co.edu.unicauca.fachadaServices.DTO.request.FormatTIDTORequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatPPDTORequest.class, name = "PP"),
    @JsonSubTypes.Type(value = FormatTIDTORequest.class, name = "TI")
})
public class FormatDTO {
    private Integer id;
    private String title;
    private String director;
    private String generalObjective;;
    private List<String> specificObjectives;
}
