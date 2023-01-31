package ar.edu.utn.frlp.ds.miAlojamiento.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosLogin;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;


/**
 * Repositorio de la entidad Login
 * 
 * @author Mauro
 * 
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	public Optional<Login> findById(Long id);

	public Login saveAndFlush(Login login);

	public List<Login> findAll();

	public List<DatosLogin> findAllProjectedBy();

}