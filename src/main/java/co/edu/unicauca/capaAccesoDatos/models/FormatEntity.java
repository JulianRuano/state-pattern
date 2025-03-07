package co.edu.unicauca.capaAccesoDatos.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatPPEntity.class, name = "FormatPPEntity"),
    @JsonSubTypes.Type(value = FormatTIEntity.class, name = "FormatTIEntity"),
})
public  class FormatEntity {
    private Integer id;
    private String title;
    private String director;
    private Date date;
    private String generalObjective;
    private List<String> specificObjectives;

    private String state;
}
