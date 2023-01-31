package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;


/**
 * Repositorio de la entidad Rol
 * 
 * @author Mauro
 * 
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	public Optional<Rol> findById(Long id);

	public Rol saveAndFlush(Rol rol);

	public List<Rol> findAll();

	public List<DatosRol> findAllProjectedBy();

}