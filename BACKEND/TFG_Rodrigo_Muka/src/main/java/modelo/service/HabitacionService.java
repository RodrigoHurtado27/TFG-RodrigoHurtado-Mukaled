package modelo.service;

import java.math.BigDecimal;
import java.util.List;

import model.Habitacion;

public interface HabitacionService {

	Habitacion findById(int idHabitacion);
	List<Habitacion> findAll();
	Habitacion insert(Habitacion habitacion);
	Habitacion update(Habitacion habitacion);
	Integer delete(int idHabitacion);
	List<Habitacion> filtrarPorEstado(String estado);
	List<Habitacion> filtrarPorCapacidad(int capacidad);
	List<Habitacion> filtrarPorPrecioMaximo(BigDecimal precioDia);
}
