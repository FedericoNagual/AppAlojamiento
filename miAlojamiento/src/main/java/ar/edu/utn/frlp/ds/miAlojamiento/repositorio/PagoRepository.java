package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;


/**
 * Repositorio de la entidad Pago
 * 
 * @author Mauro
 * 
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

	public Optional<Pago> findById(Long id);

	public Pago saveAndFlush(Pago Pago);

	public List<Pago> findAll();

	public List<DatosPago> findAllProjectedBy();

}