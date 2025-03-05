package co.edu.unicauca.capaAccesoDatos.models;

import java.sql.Date;
import java.util.List;

import co.edu.unicauca.fachadaServices.states.Result;
import co.edu.unicauca.fachadaServices.states.StatesInt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatEntity {
    private Integer id;
    private String title;
    private String director;
    private Date date;
    private String generalObjective;
    private List<String> specificObjectives;

    private String state;
}
