package restexamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restexamen.modelo.entities.Empleado;
import restexamen.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Empleado insertOne(Empleado empleado) {
		
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado findOne(int idEmpleado) {
		
		return empleadoRepository.findById(idEmpleado).orElse(null);
	}

	@Override
	public List<Empleado> findAll() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		
		try {
			
			return empleadoRepository.save(empleado);
			
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idEmpleado) {
		
		try {
			empleadoRepository.deleteById(idEmpleado);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}

}
