package modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Perfil;
import modelo.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public Perfil findByIdPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findById(idPerfil).orElse(null);
	}
	
	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return perfilRepository.findAll();
	}

	@Override
	public Perfil insert(Perfil perfil) {
		
		 try {
		        return perfilRepository.save(perfil);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		}

	@Override
	public Perfil update(Perfil perfil) {
		 try {
		        if (perfil.getIdPerfil() != 0 && perfilRepository.existsById(perfil.getIdPerfil())) {
		            return perfilRepository.save(perfil);
		        } else {
		            return null;  // no existe para actualizar
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;  // error inesperado
		    }
	}

	@Override
	public Integer delete(int idPerfil) {
		int filas = 0;
		if(perfilRepository.existsById(idPerfil)) {
		try {
			perfilRepository.deleteById(idPerfil);
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
