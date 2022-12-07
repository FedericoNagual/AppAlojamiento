package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;



/**
 * Repositorio de la entidad Pais
 * 
 * @author Mauro
 * @author Federico
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	public Optional<Pais> findById(Long id);

	public Pais saveAndFlush(Pais pais);

	public List<Pais> findAll();

	public List<DatosPais> findAllProjectedBy();

}