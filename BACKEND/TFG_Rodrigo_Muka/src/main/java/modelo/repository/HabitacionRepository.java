package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Habitacion;
import java.util.List;
import java.math.BigDecimal;



public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

	//HABITACION POR CAPACIDAD DE PERSONAS
	List<Habitacion> findByCapacidadGreaterThanEqual(int capacidad);
	//HABITACION POR PRECIO
	List<Habitacion> findByPrecioDiaLessThanEqual(BigDecimal precio_dia);
	//HABITACION POR ESTADO (OCUPADO DISPONIBLE EN MANTENIMIENTO)
	List<Habitacion> findByEstadoIgnoreCase(String estado);
	//HABITACION POR NOMBRE
	List<Habitacion> findByNombreContainingIgnoreCase(String nombre);
	//HABITACION POR DESCRIPCIÓN
	List<Habitacion> findByDescripcionContainingIgnoreCase(String descripcion);
	//HABITACION CON DOBLE FILTRO(PRECIO + CAPACIDAD)
	List<Habitacion> findByPrecioDiaLessThanEqualAndCapacidadGreaterThanEqual(BigDecimal precioDia, int capacidad);
}
