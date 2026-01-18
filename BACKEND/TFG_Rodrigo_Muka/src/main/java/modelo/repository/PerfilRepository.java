package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Perfil;
import java.util.List;


public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
	List<Perfil> findByNombre(String nombre);
	List<Perfil> findByNombreContainingIgnoreCase(String nombre);

}
