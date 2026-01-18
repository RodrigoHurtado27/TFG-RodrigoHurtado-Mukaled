package modelo.service;

import java.math.BigDecimal;
import java.util.List;
import model.Reservas;

public interface ReservasService {

	Reservas findById(int idReserva);
	List<Reservas> findAll();
	Reservas insert(Reservas reservas);
	Reservas update(Reservas reservas);
	Integer delete(int idReserva);
	List<Reservas> findByEstado(String estado);
	List<Reservas> filtrarPorPrecioTotal(BigDecimal totalPrecio);
}
