package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;



public interface ServicioCiudad {

	public Ciudad guardarCiudad(Ciudad foto);

	public Ciudad buscarCiudadXId(Long id);


	public List<Ciudad> buscarCiudadXNombre(String nombre);
	
	public List<DatoCiudad> obtenerDatosCiudad();

	public void eliminarCiudad(Long id);


	public List<Ciudad> buscarCiudadAll();


}