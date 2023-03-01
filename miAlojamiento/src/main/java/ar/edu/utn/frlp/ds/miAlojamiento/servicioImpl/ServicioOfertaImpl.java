package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosOferta;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.OfertaRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioOferta;

/**
 * Implementacion del Servicio Oferta
 * 
 * @author Mauro
 * @author Federico
 *
 */
@SessionScope
@Service
public class ServicioOfertaImpl implements ServicioOferta {
	@Autowired
	private OfertaRepository OfertaRepository;

	/**
	 * Guarda la entity Oferta
	 * 
	 */
	@Override
	public Oferta guardarOferta(Oferta Oferta) {
		return OfertaRepository.saveAndFlush(Oferta);
	}

	/**
	 * Busca una entity Oferta por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Oferta> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Oferta> buscarOfertaXFechaInicio(Date fechaInicio) {
		// Implementar metodo que devuelva todas las Oferta por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Oferta> listaGeneral = OfertaRepository.findAll();
		List<Oferta> lista = new ArrayList<Oferta>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (fechaInicio.equals(listaGeneral.get(i).getFechaInicio())) {
				lista.add(listaGeneral.get(i));
			}
		}
		return lista;
	}

	/**
	 * Buscar entity Oferta por Id
	 * 
	 * @param id tipo Long
	 * @return Oferta resultado del metodo findById
	 */
	@Override
	public Oferta buscarOfertaXId(Long id) {
		return OfertaRepository.findById(id).get();
	}

	/**
	 * Obtener DatosOferta
	 * 
	 * @return List<DatosOferta> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosOferta> obtenerDatosOferta() {
		return OfertaRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Oferta de la BD
	 */
	@Override
	public void eliminarOferta(Long id) {
		OfertaRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Oferta que existen
	 * 
	 * @return List<Oferta> resultado del metodo findAll()
	 */
	@Override
	public List<Oferta> buscarOfertaAll() {
		List<Oferta> ListaCompleta = OfertaRepository.findAll();
		return ListaCompleta;
	}

}
