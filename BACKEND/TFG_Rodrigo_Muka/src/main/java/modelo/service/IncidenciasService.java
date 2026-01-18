package modelo.service;

import java.util.List;

import model.Incidencias;

public interface IncidenciasService {

	Incidencias findById(int idIncidencias);
	List<Incidencias> findAll();
	Incidencias insert(Incidencias incidencias);
	Incidencias update(Incidencias incidencias);
	Integer delete(int idIncidencias);
	
}
