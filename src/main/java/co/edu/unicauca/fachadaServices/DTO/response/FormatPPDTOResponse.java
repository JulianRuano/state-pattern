package co.edu.unicauca.fachadaServices.DTO.response;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatPPDTOResponse extends FormatDTOResponse{

    private String advisor;
    private String student1;

    public FormatPPDTOResponse(Integer id, String title, String director, String generalObjective,
            List<String> specificObjectives, Date date, String state, String advisor, String student1) {
        super(id, title, director, generalObjective, specificObjectives, date, state);
        this.advisor = advisor;
        this.student1 = student1;
    }


}
