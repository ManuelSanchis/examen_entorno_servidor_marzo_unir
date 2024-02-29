package restexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restexamen.modelo.entities.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

}
