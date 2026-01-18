package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Incidencias;
import java.util.List;


public interface IncidenciasRepository extends JpaRepository<Incidencias, Integer> {

	List<Incidencias> findByUsuarioUsername(String username);
	//VEMOS EL ESTADO DE LA INCIDENCIA (ACTIVO, CERRADO O EN PROCESO)
	List<Incidencias> findByEstado(String estado);
	List<Incidencias> findByHabitacionIdHabitacion(Integer idHabitacion);
	//POR ESTADO Y HABITACION
	List<Incidencias> findByEstadoAndHabitacionIdHabitacion(String estado, Integer idHabitacion);
	List<Incidencias> findAllByOrderByFechaAsc();
	List<Incidencias> findAllByOrderByFechaDesc();
	
}
