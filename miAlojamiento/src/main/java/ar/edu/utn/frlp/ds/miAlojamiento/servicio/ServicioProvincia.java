package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;



public interface ServicioProvincia {

	public Provincia guardarProvincia(Provincia provincia);

	public Provincia buscarProvinciaXId(Long id);


	public List<Provincia> buscarProvinciaXNombre(String nombre);
	
	List<DatoProvincia> obtenerDatosProvincia();

	public void eliminarProvincia(Long id);


	public List<Provincia> buscarProvinciaAll();

}

