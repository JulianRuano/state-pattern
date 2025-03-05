package co.edu.unicauca.capaAccesoDatos.models;

import java.sql.Date;
import java.util.List;

import co.edu.unicauca.fachadaServices.states.StatesInt;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatTIEntity extends FormatEntity {
    private String student1;
    private String student2;

    public FormatTIEntity(Integer id, String title, String director, Date date, String generalObjective,
            List<String> specificObjectives, StatesInt state, String student1, String student2) {
        super(id, title, director, date, generalObjective, specificObjectives, state);
        this.student1 = student1;
        this.student2 = student2;
    }
}
