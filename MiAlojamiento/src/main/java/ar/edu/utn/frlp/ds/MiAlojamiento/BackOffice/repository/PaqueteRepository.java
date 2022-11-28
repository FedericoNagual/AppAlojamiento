package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPaquete;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Paquete;

/**
 * Repositorio de la entidad Paquete
 * 
 * @author 
 * 
 */
@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {

	public Optional<Paquete> findById(Long id);

	public Paquete saveAndFlush(Paquete paquete);

	public List<Paquete> findAll();

	public List<DatosPaquete> findAllProjectedBy();

}
