package restexamen.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import restexamen.modelo.dto.EmpleadoEnProyectoDto;
import restexamen.modelo.entities.Empleado;
import restexamen.modelo.entities.EmpleadoEnProyecto;
import restexamen.service.EmpleadoEnProyectoService;
import restexamen.service.EmpleadoService;
import restexamen.service.ProyectoService;

@RestController
@CrossOrigin(origins = "*")
public class EmpleadoRestController {
	
	/*
	 * POSIBLES PREGUNTAS EN EL EXAMEN
	 * 
	 * - Asignar empleados
	 * - Ver empleados
	 * - Ver empleados sin proyecto
	 */
	
	// ¡¡No se muestra el HttpStatus!!
	

	// Desde el rest llamamos a los metodos del service.
	
	// Indica que Spring debe automáticamente inyectar una instancia de las clases especificadas.
	@Autowired
	private EmpleadoService empleadoService;
	// Indica que Spring debe automáticamente inyectar una instancia de las clases especificadas.
	@Autowired
	private EmpleadoEnProyectoService empleadoEnProyectoService;
	// Indica que Spring debe automáticamente inyectar una instancia de las clases especificadas.
	@Autowired
	private ProyectoService proyectoService;
	
	// CREATE
	
	@PostMapping("/altaEmpleado")
	public Empleado altaEmpleado(@RequestBody Empleado empleado) {
		
		return empleadoService.insertOne(empleado);
	}
	
	// Asignar empleados
	
	/**
	 * Método asociado a la ruta "/elegirEmpleado" que responde a las solicitudes HTTP POST.
	 * Recibe un objeto DTO de tipo EmpleadoEnProyectoDto en el cuerpo de la solicitud mediante la anotación @RequestBody.
	 * Este método se encarga de asignar un empleado a un proyecto, creando y registrando un 
	 * objeto EmpleadoEnProyecto en la base de datos.
	 *
	 * @param empleadoEnProyectoDto Objeto de tipo EmpleadoEnProyectoDto que contiene la información necesaria para la asignación.
	 * @return El objeto EmpleadoEnProyecto recién creado y registrado en la base de datos.
	 */
	@PostMapping("/elegirEmpleado")
	public EmpleadoEnProyecto elegirEmpleado(@RequestBody EmpleadoEnProyectoDto empleadoEnProyectoDto) {
		// Crea un nuevo objeto EmpleadoEnProyecto.
		EmpleadoEnProyecto empleado = new EmpleadoEnProyecto();
		// Establece los días previstos del proyecto obteniéndolos a través del servicio proyectoService.
		empleado.setDiasPrevistos(proyectoService.findOne(empleadoEnProyectoDto.getIdProyecto()).getDiasPrevistos());
		// Establece la fecha de incorporación del empleado como la fecha actual.
		empleado.setFechaIncorporacion(new Date());
		// Establece el empleado en base al ID proporcionado en el EmpleadoEnProyectoDto.
		empleado.setEmpleado(empleadoService.findOne(empleadoEnProyectoDto.getIdEmpleado()));
		// Establece el proyecto en base al ID proporcionado en el EmpleadoEnProyectoDto.
		empleado.setProyecto(proyectoService.findOne(empleadoEnProyectoDto.getIdProyecto()));
		// Inserta el empleado en el proyecto
		return empleadoEnProyectoService.insertOne(empleado);
	}
	
	// READ
	
	@GetMapping("/mostrarEmpleado/{idEmpleado}")
	public Empleado mostrarEmpleado(@PathVariable int idEmpleado) {
		
		return empleadoService.findOne(idEmpleado);
	}
	
	// Ver empleados
	
	/**
	 * Método asociado a la ruta "/mostrarEmpleados" que responde a las solicitudes HTTP GET.
	 * Devuelve una lista que contiene a todos los empleados registrados en la base de datos.
	 *
	 * @return Lista de todos los empleados.
	 */
	@GetMapping("/mostrarEmpleados")
	public List<Empleado> mostrarEmpleados() {
		// Invoca el servicio empleadoService para recuperar la lista completa de empleados.
	    // Devuelve la lista de empleados.
		return empleadoService.findAll();
	}
	
	// Ver empleados sin proyecto
	
	/**
	 * Método asociado a la ruta "/mostrarSinProyecto" que responde a las solicitudes HTTP GET.
	 * Devuelve una lista de empleados que actualmente no tienen asignado ningún proyecto.
	 *
	 * @return Lista de empleados sin proyecto asignado.
	 */
	@GetMapping("/mostrarSinProyecto")
	public List<Empleado> mostrarSinProyecto(){
		// Invoca el servicio empleadoService para recuperar la lista de empleados sin proyecto asignado.
		// Devuelve la lista de empleados sin proyecto.
		return empleadoService.findEmpleadosSinProyecto();
	}
	
	// UPDATE
	
	@PutMapping("/modificarEmpleado")
	public Empleado modificarEmpleado(@RequestBody Empleado empleado) {
		
		return empleadoService.updateOne(empleado);
	}
	
	// DELETE
	
	@DeleteMapping("/eliminarEmpleado/{idEmpleado}")
	public String eliminarEmpleado(@PathVariable int idEmpleado) {
		
		if (empleadoService.deleteOne(idEmpleado)) {
			
			return "Eliminado con éxito";
		}
		else {
			
			return "Error";
		}
	}
	
}

