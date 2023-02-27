package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosLogin;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.LoginRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioLogin;

/**
 * Implementacion del Servicio Login
 * 
 * @author Mauro
 * @author Federico
 *
 */

@SessionScope
@Service
public class ServicioLoginImpl implements ServicioLogin {

	@Autowired
	private LoginRepository loginRepository;

	/**
	 * Guarda la entity Login
	 * 
	 */
	@Override
	public Login guardarLogin(Login Login) {
		return loginRepository.saveAndFlush(Login);
	}

	/**
	 * Busca una entity Login por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Login> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Login> buscarLoginXNombre(String nombre) {
		// Implementar metodo que devuelva todas las Login por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Login> listaGeneral = loginRepository.findAll();
		List<Login> lista = new ArrayList<Login>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Login por Id
	 * 
	 * @param id tipo Long
	 * @return Login resultado del metodo findById
	 */
	@Override
	public Login buscarLoginXId(Long id) {
		return loginRepository.findById(id).get();
	}

	/**
	 * Obtener DatosLogin
	 * 
	 * @return List<DatosLogin> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosLogin> obtenerDatosLogin() {
		return loginRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Login de la BD
	 */
	@Override
	public void eliminarLogin(Long id) {
		loginRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Login que existen
	 * 
	 * @return List<Login> resultado del metodo findAll()
	 */
	@Override
	public List<Login> buscarLoginAll() {
		List<Login> ListaCompleta = loginRepository.findAll();
		return ListaCompleta;
	}

}
