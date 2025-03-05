package co.edu.unicauca.fachadaServices.DTO.request;

import java.util.List;

import co.edu.unicauca.fachadaServices.DTO.FormatDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatPPDTORequest extends FormatDTO {

    private String advisor;
    private String student1;

    public FormatPPDTORequest(Integer id, String title, String director, String generalobjective,
            List<String> specificobjectives, String advisor, String student1) {
        super(id, title, director, generalobjective, specificobjectives);
        this.student1 = student1;
        this.advisor = advisor;
    }
 
}
