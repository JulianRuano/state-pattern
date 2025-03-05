package co.edu.unicauca.fachadaServices.DTO.response;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatPPDTOResponse extends FormatDTO{
    private String advisor;
    private String student1;
    private Date date;

    public FormatPPDTOResponse(Integer id, String title, String director, String generalobjective,
            List<String> specificobjectives, String advisor, String student1, Date date) {
        super(id, title, director, generalobjective, specificobjectives);
        this.student1 = student1;
        this.advisor = advisor;
        this.date = date;
    }
}
