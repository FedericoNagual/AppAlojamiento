package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosReserva;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Reserva;

/**
 * Repositorio de la entidad Reserva
 * 
 * @author 
 * 
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	public Optional<Reserva> findById(Long id);

	public Reserva saveAndFlush(Reserva reserva);

	public List<Reserva> findAll();

	public List<DatosReserva> findAllProjectedBy();

}
