package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosDomicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;

/**
 * Repositorio de la entidad Domicilio
 * 
 * @author Mauro
 * 
 */
@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {

	public Optional<Domicilio> findById(Long id);

	public Domicilio saveAndFlush(Domicilio domicilio);

	public List<Domicilio> findAll();

	public List<DatosDomicilio> findAllProjectedBy();

}
