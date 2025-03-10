package co.edu.unicauca.capaAccesoDatos.models;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatPPEntity extends FormatEntity {
    private String student1;
    private String advisor;

    public FormatPPEntity(Integer id, String title, String director, Date date, String generalObjective,
            List<String> specificObjectives, String state, String advisor) {

        super(id, title, director, date, generalObjective, specificObjectives, state);
        this.advisor = advisor;
    }

}
