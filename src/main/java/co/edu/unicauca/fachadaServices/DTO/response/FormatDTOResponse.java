package co.edu.unicauca.fachadaServices.DTO.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatDTOResponse {
    private Integer id;
    private String title;
    private String director;
    private String generalObjective;
    private List<String> specificObjectives;
    private Date date;
    private String state;
}
