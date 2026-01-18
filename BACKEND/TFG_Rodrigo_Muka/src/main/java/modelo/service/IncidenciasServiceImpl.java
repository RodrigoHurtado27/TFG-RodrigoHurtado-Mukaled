package modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Incidencias;
import modelo.repository.IncidenciasRepository;

@Service
public class IncidenciasServiceImpl implements IncidenciasService{

	@Autowired
	private IncidenciasRepository incidenciasRepository;
	
	@Override
	public Incidencias findById(int idIncidencias) {
		// TODO Auto-generated method stub
		return incidenciasRepository.findById(idIncidencias).orElse(null);
	}

	@Override
	public List<Incidencias> findAll() {
		// TODO Auto-generated method stub
		return incidenciasRepository.findAll();
	}

	@Override
	public Incidencias insert(Incidencias incidencias) {
		try {
	        return incidenciasRepository.save(incidencias);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public Incidencias update(Incidencias incidencias) {
		try {
	        if (incidencias.getIdIncidencia() != 0 && incidenciasRepository.existsById(incidencias.getIdIncidencia())) {
	            return incidenciasRepository.save(incidencias);
	        } else {
	            return null;  // no existe para actualizar
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;  // error inesperado
	    }
	}

	@Override
	public Integer delete(int idIncidencias) {

		int filas = 0;
		if(incidenciasRepository.existsById(idIncidencias)) {
		try {
			incidenciasRepository.deleteById(idIncidencias);
			filas = 1;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			filas = -1;
		}
	}else
		filas = 0;
	return filas;
	}

}
