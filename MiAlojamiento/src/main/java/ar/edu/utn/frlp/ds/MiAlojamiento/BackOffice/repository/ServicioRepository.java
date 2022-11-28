package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosServicio;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Servicio;

/**
 * Repositorio de la entidad Servicio
 * 
 * @author 
 * 
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	public Optional<Servicio> findById(Long id);

	public Servicio saveAndFlush(Servicio servicio);

	public List<Servicio> findAll();

	public List<DatosServicio> findAllProjectedBy();

}