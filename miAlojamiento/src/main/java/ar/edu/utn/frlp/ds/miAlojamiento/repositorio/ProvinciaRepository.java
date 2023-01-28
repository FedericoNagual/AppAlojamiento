package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;



/**
 * Repositorio de la entidad Provincia
 * 
 * @author Mauro
 * 
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

	public Optional<Provincia> findById(Long id);

	public Provincia saveAndFlush(Provincia ciudad);

	public List<Provincia> findAll();

	public List<DatoProvincia> findAllProjectedBy();

}
