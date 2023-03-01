package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.PaisRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioPais;

/**
 * Implementacion del Servicio Pais
 * 
 * @author Mauro
 * @author Federico
 *
 */
@SessionScope
@Service
public class ServicioPaisImpl implements ServicioPais {

	@Autowired
	private PaisRepository paisRepository;

	/**
	 * Guarda la entity Pais
	 * 
	 */
	@Override
	public Pais guardarPais(Pais pais) {
		return paisRepository.saveAndFlush(pais);
	}

	/**
	 * Busca una entity Pais por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Pais> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Pais> buscarPaisXNombre(String nombre) {
		// Implementar metodo que devuelva todas las Pais por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Pais> listaGeneral = paisRepository.findAll();
		List<Pais> lista = new ArrayList<Pais>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
		}
		return lista;
	}

	/**
	 * Buscar entity Pais por Id
	 * 
	 * @param id tipo Long
	 * @return Pais resultado del metodo findById
	 */
	@Override
	public Pais buscarPaisXId(Long id) {
		return paisRepository.findById(id).get();
	}

	/**
	 * Obtener DatosPais
	 * 
	 * @return List<DatosPais> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosPais> obtenerDatosComboPais() {
		return paisRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Pais de la BD
	 */
	@Override
	public void eliminarPais(Long id) {
		paisRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Pais que existen
	 * 
	 * @return List<Pais> resultado del metodo findAll()
	 */
	@Override
	public List<Pais> buscarPaisAll() {
		List<Pais> ListaCompleta = paisRepository.findAll();
		return ListaCompleta;
	}

}
