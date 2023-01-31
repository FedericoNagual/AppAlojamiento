package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosLogin;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;


public interface ServicioLogin {

	public Login guardarLogin(Login Login);

	public Login buscarLoginXId(Long id);


	public List<Login> buscarLoginXNombre(String nombre);
	
	public List<DatosLogin> obtenerDatosLogin();

	public void eliminarLogin(Long id);

	public List<Login> buscarLoginAll();


}