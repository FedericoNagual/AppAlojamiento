package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Ciudad;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatoCiudad;


public interface ServicioCiudad {

	public Ciudad guardarCiudad(Ciudad foto);

	public Ciudad buscarCiudadXId(Long id);


	public List<Ciudad> buscarCiudadXNombre(String nombre);
	
	List<DatoCiudad> obtenerDatosCiudad();

	public void eliminarCiudad(Long id);




}