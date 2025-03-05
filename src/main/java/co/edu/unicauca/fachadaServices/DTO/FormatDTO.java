package co.edu.unicauca.fachadaServices.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatDTO {
    private Integer id;
    private String title;
    private String director;
    private String generalobjective;;
    private List<String> specificobjectives;
}
