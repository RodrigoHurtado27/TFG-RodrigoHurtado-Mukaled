package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reservas;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;



public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

	//SABER SI LA HABITACION ESTA OCUPADA O LIBRE
	List<Reservas> findByEstado(String estado);
	List<Reservas> findByUsuarioUsername(String username);
	List<Reservas> findByTotalPrecioLessThanEqual(BigDecimal totalPrecio);
	List<Reservas> findByFechaInicioBetweenAndTotalPrecioLessThanEqual(LocalDate inicio, LocalDate fin, BigDecimal precioMax);
	
}
