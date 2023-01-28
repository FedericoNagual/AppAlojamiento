package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;


public interface ServicioPais {

	public Pais guardarPais(Pais pais);

	public Pais buscarPaisXId(Long id);


	public List<Pais> buscarPaisXNombre(String nombre);
	
	List<DatosPais> obtenerDatosComboPais();

	public void eliminarPais(Long id);
	
	public List<Pais> buscarPaisAll();


}
