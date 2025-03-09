package co.edu.unicauca.capaAccesoDatos.repositories;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.capaAccesoDatos.models.FormatEntity;

@Repository("IDFormatoRepository")
public class FormatRepository {

    private Map<Integer, FormatEntity> formatos;

    public FormatRepository() {
        formatos = new HashMap<>();
    }

    // Guardar un formato
    public FormatEntity save(FormatEntity format) {
        format.setId(formatos.size() + 1);
        formatos.put(format.getId(), format);
        return format;
    }

    // Actualizar un formato
    public FormatEntity update(FormatEntity formato) {
        return formatos.put(formato.getId(), formato);  
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

    public Collection<FormatEntity> findByDateRange(Date startDate, Date endDate) {
        return formatos.values().stream()
                .filter(format -> {
                    Date formatDate = format.getDate();
                    return formatDate != null && !formatDate.before(startDate) && !formatDate.after(endDate);
                })
                .collect(Collectors.toList());
    }
}
