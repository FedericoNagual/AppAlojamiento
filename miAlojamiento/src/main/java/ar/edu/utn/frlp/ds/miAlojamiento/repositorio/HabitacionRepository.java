package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosHabitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;

/**
 * Repositorio de la entidad Habitacion
 * 
 * @author Federico
 * 
 */
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

	public Optional<Habitacion> findById(Long id);

	public Habitacion saveAndFlush(Habitacion habitacion);

	public List<Habitacion> findAll();

	public List<DatosHabitacion> findAllProjectedBy();

}
