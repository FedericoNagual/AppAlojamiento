package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.RolRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioRol;

/**
 * Implementacion del Servicio Rol
 * 
 * @author Mauro
 * @author Federico
 *
 */

@SessionScope
@Service
public class ServicioRolImpl implements ServicioRol {

	@Autowired
	private RolRepository rolRepository;

	/**
	 * Guarda la entity Rol
	 * 
	 */
	@Override
	public Rol guardarRol(Rol rol) {
		return rolRepository.saveAndFlush(rol);
	}

	/**
	 * Busca una entity Rol por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Rol> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Rol> buscarRolXDescripcion(String descripcion) {
		// Implementar metodo que devuelva todas las Rol por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Rol> listaGeneral = rolRepository.findAll();
		List<Rol> lista = new ArrayList<Rol>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (descripcion.equals(listaGeneral.get(i).getDescripcion())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Rol por Id
	 * 
	 * @param id tipo Long
	 * @return Rol resultado del metodo findById
	 */
	@Override
	public Rol buscarRolXId(Long id) {
		return rolRepository.findById(id).get();
	}

	/**
	 * Obtener DatosRol
	 * 
	 * @return List<DatosRol> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosRol> obtenerDatosRol() {
		return rolRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Rol de la BD
	 */
	@Override
	public void eliminarRol(Long id) {
		rolRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Rol que existen
	 * 
	 * @return List<Rol> resultado del metodo findAll()
	 */
	@Override
	public List<Rol> buscarRolAll() {
		List<Rol> ListaCompleta = rolRepository.findAll();
		return ListaCompleta;
	}

}
