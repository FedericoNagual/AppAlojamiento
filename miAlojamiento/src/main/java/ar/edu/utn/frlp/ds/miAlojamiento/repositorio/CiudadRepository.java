package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;



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

