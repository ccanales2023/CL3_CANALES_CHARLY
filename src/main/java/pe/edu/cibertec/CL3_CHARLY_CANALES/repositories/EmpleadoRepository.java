package pe.edu.cibertec.CL3_CHARLY_CANALES.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import pe.edu.cibertec.CL3_CHARLY_CANALES.entities.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
    
    List<Empleado> findAll();

}
