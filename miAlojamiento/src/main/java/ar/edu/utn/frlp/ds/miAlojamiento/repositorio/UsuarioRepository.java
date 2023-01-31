package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;



/**
 * Repositorio de la entidad Usuario
 * 
 * @author Mauro
 * 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findById(Long id);

	public Usuario saveAndFlush(Usuario usuario);

	public List<Usuario> findAll();

	public List<DatosUsuario> findAllProjectedBy();

}