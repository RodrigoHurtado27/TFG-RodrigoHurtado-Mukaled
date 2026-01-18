package modelo.service;

import java.util.List;

import model.Habitacion;
import model.Usuario;

public interface UsuarioService {

	Usuario findByUsername(String username);
	List<Usuario> findAll();
	Usuario insert(Habitacion habitacion);
	Usuario update(Habitacion habitacion);
	Integer delete(String username);
}
