package co.edu.unicauca.fachadaServices.DTO.response;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatTIDTOResponse extends FormatDTO {
    private String student1;
    private String student2;
    private Date date;

    public FormatTIDTOResponse(Integer id, String title, String director, String generalobjective,
            List<String> specificobjectives, String student1, String student2, Date date) {
        super(id, title, director, generalobjective, specificobjectives);
        this.student1 = student1;
        this.student2 = student2;
        this.date = date;
    }

}
