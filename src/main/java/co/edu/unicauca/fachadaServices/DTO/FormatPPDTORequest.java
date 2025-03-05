package co.edu.unicauca.fachadaServices.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatPPDTORequest extends FormatDTO {

    private String advisor;

    public FormatPPDTORequest(Integer id, String title, String director, String generalobjective,
            List<String> specificobjectives, String advisor) {
        super(id, title, director, generalobjective, specificobjectives);
        this.advisor = advisor;
    }
 
}
