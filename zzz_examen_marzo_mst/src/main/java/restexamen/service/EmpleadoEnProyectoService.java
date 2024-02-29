package restexamen.service;

import java.util.List;

import restexamen.modelo.entities.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoService {
	
	// Create
	EmpleadoEnProyecto insertOne(EmpleadoEnProyecto empleadoEnProyecto);
		
	// Read
	EmpleadoEnProyecto findOne(int idEntrada);
	List<EmpleadoEnProyecto> findAll();
		
	// Update
	EmpleadoEnProyecto updateOne(EmpleadoEnProyecto empleadoEnProyecto);
		
	// Delete
	boolean deleteOne(int idEntrada);

}
