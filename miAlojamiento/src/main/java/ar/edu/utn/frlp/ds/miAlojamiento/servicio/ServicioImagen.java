package ar.edu.utn.frlp.ds.miAlojamiento.servicio;


import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosImagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;


public interface ServicioImagen {


	public Imagen guardarImagen(Imagen imagen);

	public Imagen buscarImagenXId(Long id);


	public List<Imagen> buscarImagenXUrl(String url);
	
	public List<DatosImagen> obtenerDatosImagen();

	public void eliminarImagen(Long id);


	public List<Imagen> buscarImagenAll();


}

