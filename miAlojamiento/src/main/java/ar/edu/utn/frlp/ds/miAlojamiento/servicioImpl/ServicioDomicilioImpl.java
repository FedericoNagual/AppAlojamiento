package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosDomicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.DomicilioRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioDomicilio;

/**
 * Implementacion del Servicio Domicilio
 * 
 * @author Mauro
 * @author Federico
 *
 */
@SessionScope
@Service
public class ServicioDomicilioImpl implements ServicioDomicilio {
	
	@Autowired
	private DomicilioRepository domicilioRepository;

	/**
	 * Guarda la entity Domicilio
	 * 
	 */
	@Override
	public Domicilio guardarDomicilio(Domicilio domicilio) {
		return domicilioRepository.saveAndFlush(domicilio);
	}

	/**
	 * Busca una entity Domicilio por calle
	 * 
	 * 
	 * @return List<Domicilio> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Domicilio> buscarDomicilioXCalle(String calle) {
		// Implementar metodo que devuelva todas las Ciudad por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre de calle
		List<Domicilio> listaGeneral = domicilioRepository.findAll();
		List<Domicilio> lista = new ArrayList<Domicilio>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (calle.equals(listaGeneral.get(i).getCalle())) {
				lista.add(listaGeneral.get(i));
			}
		}
		return lista;
	}

	/**
	 * Buscar entity Domicilio por Id
	 * 
	 * @param id tipo Long
	 * @return Domicilio resultado del metodo findById
	 */
	@Override
	public Domicilio buscarDomicilioXId(Long id) {
		return domicilioRepository.findById(id).get();
	}

	/**
	 * Obtener DatosDomicilio
	 * 
	 * @return List<DatosDomicilio> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosDomicilio> obtenerDatosDomicilio() {
		return domicilioRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Domicilio de la BD
	 */
	@Override
	public void eliminarDomicilio(Long id) {
		domicilioRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Domicilio que existen
	 * 
	 * @return List<Domicilio> resultado del metodo findAll()
	 */
	@Override
	public List<Domicilio> buscarDomicilioAll() {
		List<Domicilio> ListaCompleta = domicilioRepository.findAll();
		return ListaCompleta;
	}

}
