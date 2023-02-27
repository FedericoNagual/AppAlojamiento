package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.UsuarioRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioUsuario;

/**
 * Implementacion del Servicio Usuario
 * 
 * @author Mauro
 * @author Federico
 *
 */
@SessionScope
@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Guarda la entity Usuario
	 * 
	 */
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	/**
	 * Busca una entity Usuario por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Usuario> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Usuario> buscarUsuarioXDNI(String dni) {
		// Implementar metodo que devuelva todas las Usuario por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Usuario> listaGeneral = usuarioRepository.findAll();
		List<Usuario> lista = new ArrayList<Usuario>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (dni.equals(listaGeneral.get(i).getDni())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Usuario por Id
	 * 
	 * @param id tipo Long
	 * @return Usuario resultado del metodo findById
	 */
	@Override
	public Usuario buscarUsuarioXId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	/**
	 * Obtener DatosUsuario
	 * 
	 * @return List<DatosUsuario> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosUsuario> obtenerDatosUsuario() {
		return usuarioRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Usuario de la BD
	 */
	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Usuario que existen
	 * 
	 * @return List<Usuario> resultado del metodo findAll()
	 */
	@Override
	public List<Usuario> buscarUsuarioAll() {
		List<Usuario> ListaCompleta = usuarioRepository.findAll();
		return ListaCompleta;
	}

}
