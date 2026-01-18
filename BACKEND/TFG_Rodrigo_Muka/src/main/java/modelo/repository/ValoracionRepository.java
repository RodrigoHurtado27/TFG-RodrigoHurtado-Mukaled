package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Valoracion;
import java.util.List;



public interface ValoracionRepository extends JpaRepository<Valoracion, Integer>{

	List<Valoracion> findByUsuarioUsername(String username);
	List<Valoracion> findAllByOrderByFechaDesc();
	List<Valoracion> findByHabitacionIdHabitacion(int idHabitacion);
	List<Valoracion> findByHabitacionIdHabitacionOrderByFechaDesc(int idHabitacion);

	
}
