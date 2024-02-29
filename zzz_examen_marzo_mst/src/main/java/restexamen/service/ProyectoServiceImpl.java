package restexamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.Proyecto;
import restexamen.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public Proyecto insertOne(Proyecto proyecto) {
		
		return proyectoRepository.save(proyecto);
	}

	@Override
	public Proyecto findOne(int idProyecto) {
		
		return proyectoRepository.findById(idProyecto).orElse(null);
	}

	@Override
	public List<Proyecto> findAll() {
		
		return proyectoRepository.findAll();
	}
	
	@Override
	public Empleado findDirector(int idProyecto) {
		
		return proyectoRepository.findDirectorPorProyecto(idProyecto);
	}

	@Override
	public Proyecto updateOne(Proyecto proyecto) {
	
		try {
			
			return proyectoRepository.save(proyecto);
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	/*
	@Override
	public Proyecto updateOne(Proyecto proyecto) {
		
		if (findOne(proyecto.getIdProyecto()) != null) {
			
			return proyectoRepository.save(proyecto);
		}
		else {
			
			return null;
		}
	}
	*/

	@Override
	public boolean deleteOne(int idProyecto) {
		
		try {
			proyectoRepository.deleteById(idProyecto);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}


}