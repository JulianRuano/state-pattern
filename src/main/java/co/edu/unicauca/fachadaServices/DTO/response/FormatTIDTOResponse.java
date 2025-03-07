package co.edu.unicauca.fachadaServices.DTO.response;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatTIDTOResponse extends FormatDTOResponse {
    private String student1;
    private String student2;

    public FormatTIDTOResponse(Integer id, String title, String director, String generalObjective,
            List<String> specificObjectives, Date date, String state, String student1, String student2) {
        super(id, title, director, generalObjective, specificObjectives, date, state);
        this.student1 = student1;
        this.student2 = student2;
    }


}
