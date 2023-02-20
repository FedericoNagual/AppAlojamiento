package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosOferta;


/**
 * Repositorio de la entidad Oferta
 * 
 * @author Mauro
 * 
 */
@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {

	public Optional<Oferta> findById(Long id);

	public Oferta saveAndFlush(Oferta ciudad);

	public List<Oferta> findAll();

	public List<DatosOferta> findAllProjectedBy();

}

