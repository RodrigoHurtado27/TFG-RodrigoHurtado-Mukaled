package modelo.service;

import java.util.List;
import model.Perfil;

public interface PerfilService {
	
	Perfil findByIdPerfil(int idPerfil);
	List<Perfil> findAll();
	Perfil insert(Perfil perfil);
	Perfil update(Perfil perfil);
	Integer delete(int idPerfil);
	
}
