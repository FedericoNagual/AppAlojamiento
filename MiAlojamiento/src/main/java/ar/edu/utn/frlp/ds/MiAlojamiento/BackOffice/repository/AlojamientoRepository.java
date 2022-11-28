package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Alojamiento;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosAlojamiento;

/**
 * Repositorio de la entidad Alojamiento
 * 
 * @author 
 * 
 */
@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {

	public Optional<Alojamiento> findById(Long id);

	public Alojamiento saveAndFlush(Alojamiento ciudad);

	public List<Alojamiento> findAll();

	public List<DatosAlojamiento> findAllProjectedBy();

}

