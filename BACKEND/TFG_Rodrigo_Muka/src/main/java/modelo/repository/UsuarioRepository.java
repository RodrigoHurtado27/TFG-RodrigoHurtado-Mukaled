package modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Perfil;
import model.Usuario;
import java.util.List;



public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	List<Usuario> findByNombreAndApellidos(String nombre ,String apellido);
	List<Usuario> findByPerfil(Perfil perfil);
	List<Usuario> findAllByOrderByFechaRegistroDesc();
	List<Usuario> findByUsername(String username);
	List<Usuario> findByEnabledTrue();
	List<Usuario> findByEnabledFalse();
	List<Usuario> findByNombreContainingIgnoreCase(String nombre);
	List<Usuario> findByApellidosContainingIgnoreCase(String apellidos);


	
}
