package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosFoto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;



/**
 * Repositorio de la entidad Foto
 * 
 * @author Mauro
 * 
 */
@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

	public Optional<Foto> findById(Long id);

	public Foto saveAndFlush(Foto foto);

	public List<Foto> findAll();

	public List<DatosFoto> findAllProjectedBy();

}
