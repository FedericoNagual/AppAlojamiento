package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosImagen;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Imagen;

/**
 * Repositorio de la entidad Imagen
 * 
 * @author 
 * 
 */
@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {

	public Optional<Imagen> findById(Long id);

	public Imagen saveAndFlush(Imagen imagen);

	public List<Imagen> findAll();

	public List<DatosImagen> findAllProjectedBy();

}

