package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;


public interface ServicioRol {

	public Rol guardarRol(Rol Rol);

	public Rol buscarRolXId(Long id);


	public List<Rol> buscarRolXDescripcion(String descripcion);
	
	public List<DatosRol> obtenerDatosRol();

	public void eliminarRol(Long id);

	public List<Rol> buscarRolAll();


}