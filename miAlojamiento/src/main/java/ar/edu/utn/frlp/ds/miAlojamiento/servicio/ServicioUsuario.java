package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;


public interface ServicioUsuario {

	public Usuario guardarUsuario(Usuario Usuario);

	public Usuario buscarUsuarioXId(Long id);


	public List<Usuario> buscarUsuarioXDNI(String dni);
	
	public List<DatosUsuario> obtenerDatosUsuario();

	public void eliminarUsuario(Long id);

	public List<Usuario> buscarUsuarioAll();


}