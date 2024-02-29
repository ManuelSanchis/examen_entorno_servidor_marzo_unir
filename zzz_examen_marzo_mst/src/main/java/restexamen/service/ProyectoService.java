package restexamen.service;

import java.util.List;

import restexamen.modelo.entities.Proyecto;

public interface ProyectoService {
	
	// Create
	Proyecto insertOne(Proyecto proyecto);
		
	// Read
	Proyecto findOne(int idProyecto);
	List<Proyecto> findAll();
		
	// Update
	Proyecto updateOne(Proyecto proyecto);
		
	// Delete
	boolean deleteOne(int idProyecto);

}
