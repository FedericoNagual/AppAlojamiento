package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Ciudad;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatoCiudad;


/**
 * Repositorio de la entidad Ciudad
 * 
 * @author 
 * 
 */
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

	public Optional<Ciudad> findById(Long id);

	public Ciudad saveAndFlush(Ciudad ciudad);

	public List<Ciudad> findAll();

	public List<DatoCiudad> findAllProjectedBy();

}

