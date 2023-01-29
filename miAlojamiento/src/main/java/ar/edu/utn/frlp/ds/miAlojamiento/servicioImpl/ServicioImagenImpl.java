package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosImagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.ImagenRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioImagen;

/**
 * Implementacion del Servicio Imagen
 * 
 * @author Mauro
 *
 */
@SessionScope
@Service
public class ServicioImagenImpl implements ServicioImagen{
	@Autowired
	private ImagenRepository imagenRepository;

	/**
	 * Guarda la entity Imagen
	 * 
	 */
	@Override
	public Imagen guardarImagen(Imagen imagen) {
		return imagenRepository.saveAndFlush(imagen);
	}

	/**
	 * Busca una entity Ciudad por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Ciudad> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Imagen> buscarImagenXUrl(String url) {
		//Implementar metodo que devuelva todas las Imagenes por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Imagen> listaGeneral = imagenRepository.findAll();
		List<Imagen> lista = new ArrayList<Imagen>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (url.equals(listaGeneral.get(i).getUrl())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Imagen por Id
	 * 
	 * @param id tipo Long
	 * @return Imagen resultado del metodo findById
	 */
	@Override
	public Imagen buscarImagenXId(Long id) {
		return imagenRepository.findById(id).get();
	}

	/**
	 * Obtener DatosImagen
	 * 
	 * @return List<DatosImagen> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosImagen> obtenerDatosImagen() {
		return imagenRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Imagen de la BD
	 */
	@Override
	public void eliminarImagen(Long id) {
		imagenRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Imagen que existen
	 * @return List<Imagen> resultado del metodo findAll() 
	 */
	@Override
	public List<Imagen> buscarImagenAll() {
		List<Imagen> ListaCompleta= imagenRepository.findAll();
		return ListaCompleta;
	}
	

}

