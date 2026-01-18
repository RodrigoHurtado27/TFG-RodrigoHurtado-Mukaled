package modelo.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Habitacion;
import modelo.repository.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService{

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Override
	public Habitacion findById(int idHabitacion) {
		// TODO Auto-generated method stub
		return habitacionRepository.findById(idHabitacion).orElse(null);
	}

	@Override
	public List<Habitacion> findAll() {
		// TODO Auto-generated method stub
		return habitacionRepository.findAll();
	}

	@Override
	public Habitacion insert(Habitacion habitacion) {
	    try {
	        return habitacionRepository.save(habitacion);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public Habitacion update(Habitacion habitacion) {
	    try {
	        if (habitacion.getIdHabitacion() != 0 && habitacionRepository.existsById(habitacion.getIdHabitacion())) {
	            return habitacionRepository.save(habitacion);
	        } else {
	            return null;  // no existe para actualizar
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;  // error inesperado
	    }
	}


	@Override
	public Integer delete(int idHabitacion) {
	
		int filas = 0;
		if(habitacionRepository.existsById(idHabitacion)) {
		try {
			habitacionRepository.deleteById(idHabitacion);
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
	public List<Habitacion> filtrarPorEstado(String estado) {
		// TODO Auto-generated method stub
		return habitacionRepository.findByEstadoIgnoreCase(estado);
	}

	@Override
	public List<Habitacion> filtrarPorCapacidad(int capacidad) {
		// TODO Auto-generated method stub
		return habitacionRepository.findByCapacidadGreaterThanEqual(capacidad);
	}

	@Override
	public List<Habitacion> filtrarPorPrecioMaximo(BigDecimal precioDia) {
		// TODO Auto-generated method stub
		return habitacionRepository.findByPrecioDiaLessThanEqual(precioDia);
	}
	
}


