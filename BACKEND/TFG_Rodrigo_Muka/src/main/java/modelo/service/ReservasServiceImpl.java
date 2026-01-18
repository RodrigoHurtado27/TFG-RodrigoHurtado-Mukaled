package modelo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Reservas;
import modelo.repository.ReservasRepository;

@Service
public class ReservasServiceImpl implements ReservasService{

	@Autowired
	private ReservasRepository  reservasRepository;
	
	@Override
	public Reservas findById(int idReserva) {
		// TODO Auto-generated method stub
		return reservasRepository.findById(idReserva).orElse(null);
	}

	@Override
	public List<Reservas> findAll() {
		// TODO Auto-generated method stub
		return reservasRepository.findAll();
	}

	@Override
	public Reservas insert(Reservas reservas) {
		try {
	        return reservasRepository.save(reservas);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public Reservas update(Reservas reservas) {
		try {
	        if (reservas.getIdReserva() != 0 && reservasRepository.existsById(reservas.getIdReserva())) {
	            return reservasRepository.save(reservas);
	        } else {
	            return null;  // no existe para actualizar
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;  // error inesperado
	    }
	}

	@Override
	public Integer delete(int idReserva) {
		int filas = 0;
		if(reservasRepository.existsById(idReserva)) {
		try {
			reservasRepository.deleteById(idReserva);
			filas = 1;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			filas = -1;
		}
	}else
		filas = 0;
	return filas;
	}

	@Override
	public List<Reservas> findByEstado(String estado) {
		// TODO Auto-generated method stub
		return reservasRepository.findByEstado(estado);
	}

	@Override
	public List<Reservas> filtrarPorPrecioTotal(BigDecimal totalPrecio) {
		// TODO Auto-generated method stub
		return reservasRepository.findByTotalPrecioLessThanEqual(totalPrecio);
	}

}
