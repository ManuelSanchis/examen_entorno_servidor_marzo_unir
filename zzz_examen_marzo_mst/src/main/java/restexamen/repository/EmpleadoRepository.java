package restexamen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import restexamen.modelo.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query("select e from Empleado e where e.idEmpleado not in (select eep.empleado.idEmpleado from EmpleadoEnProyecto eep)")
	List<Empleado> findEmpleadosSinProyecto();

}
