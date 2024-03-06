package restexamen.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.Proyecto;
import restexamen.service.EmpleadoEnProyectoService;
import restexamen.service.ProyectoService;

@RestController
@CrossOrigin(origins = "*")
public class ProyectoRestController {
	
	/*
	 * POSIBLES PREGUNTAS EN EL EXAMEN
	 * 
	 * - Ver un proyecto
	 * - Ver proyectos
	 * - Ver director de un proyecto
	 * - Ver empleados de un proyecto
	 * - Modificar un proyecto
	 * - Eliminar un proyecto
	 */
	
	// ¡¡No se muestra el HttpStatus!!
	
	
	// Desde el rest llamamos a los metodos del service.
	
	// Indica que Spring debe automáticamente inyectar una instancia de las clases especificadas.
	@Autowired
	private ProyectoService proyectoService;
	// Indica que Spring debe automáticamente inyectar una instancia de las clases especificadas.
	@Autowired
	private EmpleadoEnProyectoService empleadoEnProyectoService;
	
	// CREATE
	
	@PostMapping("/altaProyecto")
	public Proyecto altaProyecto(@RequestParam Proyecto proyecto) {
		
		return proyectoService.insertOne(proyecto);
	}
	
	// READ
	
	// Ver un proyecto
	
	/**
	 * Método asociado a la ruta "/mostrarProyecto/{idProyecto}" que responde a las solicitudes HTTP GET.
	 * Devuelve la información de un proyecto específico identificado por su ID.
	 *
	 * @param idProyecto Identificador único del proyecto que se desea mostrar.
	 * @return Objeto Proyecto que contiene la información del proyecto encontrado.
	 */
	@GetMapping("/mostrarProyecto/{idProyecto}")
	public Proyecto mostrarEmpleado(@PathVariable int idProyecto) {
		// Invoca el servicio proyectoService para recuperar la información del proyecto con el ID proporcionado.
	    // Devuelve el proyecto con el ID específico.
		return proyectoService.findOne(idProyecto);
	}
		
	// Ver proyectos
	
	/**
	 * Método asociado a la ruta "/mostrarProyectos" que responde a las solicitudes HTTP GET.
	 * Devuelve una lista que contiene todos los proyectos registrados en la base de datos.
	 *
	 * @return Lista de todos los proyectos.
	 */
	@GetMapping("/mostrarProyectos")
	public List<Proyecto> mostrarProyectos() {
		// Invoca el servicio proyectoService para recuperar la lista completa de proyectos.
	    // Devuelve la lista de proyectos.
		return proyectoService.findAll();
	}
	
	// Ver director de un proyecto
	
	/**
	 * Método asociado a la ruta "/mostrarDirector/{idProyecto}" que responde a las solicitudes HTTP GET.
	 * Devuelve el director asociado a un proyecto específico identificado por su ID.
	 *
	 * @param idProyecto Identificador único del proyecto del cual se desea obtener el director.
	 * @return Objeto Empleado que representa al director del proyecto encontrado.
	 */
	@GetMapping("/mostrarDirector/{idProyecto}")
	public Empleado mostrarDirector(@PathVariable int idProyecto) {
		// Invoca el servicio proyectoService para recuperar al director asociado al proyecto con el ID proporcionado.
	    // Devuelve el director del proyecto con el ID específico.
		return proyectoService.findDirector(idProyecto);
	}
	
	// Ver empleados de un proyecto
	
	/**
	 * Método asociado a la ruta "/mostrarEmpleados/{idProyecto}" que responde a las solicitudes HTTP GET.
	 * Devuelve una lista que contiene todos los empleados asignados a un proyecto específico identificado por su ID.
	 *
	 * @param idProyecto Identificador único del proyecto del cual se desea obtener la lista de empleados.
	 * @return Lista de empleados asignados al proyecto identificado por el ID proporcionado.
	 */
	@GetMapping("/mostrarEmpleados/{idProyecto}")
	public List<Empleado> mostrarEmpleados(@PathVariable int idProyecto) {
		// Invoca el servicio empleadoEnProyectoService para recuperar la lista de empleados asignados al proyecto con el ID proporcionado.
	    // Devuelve la lista de emplelados en el proyecto con el ID específico.
		return empleadoEnProyectoService.findEmpleadosEnProyecto(idProyecto);
	}
		
	// UPDATE
	
	// Modificar un proyecto
	
	/**
	 * Método asociado a la ruta "/modificarProyecto" que responde a las solicitudes HTTP PUT.
	 * Modifica la información de un proyecto existente en la base de datos.
	 *
	 * @param proyecto Objeto de tipo Proyecto con la información actualizada que se desea aplicar al proyecto.
	 * @return Objeto Proyecto que representa el proyecto modificado en la base de datos.
	 */
	@PutMapping("/modificarProyecto")
	public Proyecto modificarProyecto(@RequestBody Proyecto proyecto) {
	    // Invoca el servicio proyectoService para actualizar la información del proyecto en la base de datos.
	    // El parámetro "proyecto" contiene la información actualizada.
	    // Devuelve el proyecto modificado.
		return proyectoService.updateOne(proyecto);
	}
		
	// DELETE
		
	// Eliminar un proyecto
	
	/**
	 * Método asociado a la ruta "/eliminarProyecto/{idProyecto}" que responde a las solicitudes HTTP DELETE.
	 * Elimina un proyecto existente en la base de datos identificado por su ID.
	 *
	 * @param idProyecto Identificador único del proyecto que se desea eliminar.
	 * @return Mensaje indicando el resultado de la operación de eliminación ("Eliminado con éxito" o "Error").
	 */
	@DeleteMapping("/eliminarProyecto/{idProyecto}")
	public String eliminarProyecto(@PathVariable int idProyecto) {
		// Invoca el servicio proyectoService para eliminar el proyecto con el ID proporcionado.
	    // Verifica si la eliminación tiene éxito y devuelve mensaje correspondiente.	
		if (proyectoService.deleteOne(idProyecto)) {
				
			return "Eliminado con éxito";
		}
		else {
				
			return "Error";
		}
	}

}
