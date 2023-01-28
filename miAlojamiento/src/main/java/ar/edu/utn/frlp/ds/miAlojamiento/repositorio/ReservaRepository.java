package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosReserva;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;


/**
 * Repositorio de la entidad Reserva
 * 
 * @author Mauro
 * 
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	public Optional<Reserva> findById(Long id);

	public Reserva saveAndFlush(Reserva reserva);

	public List<Reserva> findAll();

	public List<DatosReserva> findAllProjectedBy();

}
