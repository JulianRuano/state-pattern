package co.edu.unicauca.capaAccesoDatos.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;

@Repository("IDFormatoRepository")
public class FormatRepository {

    private Map<Integer, FormatEntity> formatos;

    public FormatRepository() {
        formatos = new HashMap<>();
    }

    // Guardar un formato
    public FormatEntity save(FormatEntity formato) {
        formatos.put(formato.getId(), formato);
        return formato;
    }

    // Actualizar un formato
    public Optional<FormatEntity> update(Integer id, FormatEntity formato) {
        Optional<FormatEntity> formatoOptional;
        if(this.formatos.containsKey(id)){
            formatoOptional = Optional.of(formatos.put(id, formato));
        }else{
            formatoOptional = Optional.empty();
        }

        return formatoOptional;
    }

    // Eliminar un formato
    public boolean delete(Integer id) {
        return this.formatos.remove(id) != null;
    }

    // Listar todos los formatos
    public Optional<Collection<FormatEntity>> findAll() {
        return formatos.isEmpty() ? Optional.empty() : Optional.of(formatos.values());
    }
    // Buscar un formato
    public Optional<FormatEntity> findById(Integer id) {
        return Optional.ofNullable(formatos.get(id));
    }
    
}
