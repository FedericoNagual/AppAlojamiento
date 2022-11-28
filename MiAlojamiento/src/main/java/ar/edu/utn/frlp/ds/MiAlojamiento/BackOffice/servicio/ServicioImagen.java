package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosImagen;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Imagen;

public interface ServicioImagen {


	public Imagen guardarImagen(Imagen imagen);

	public Imagen buscarImagenXId(Long id);


	public List<Imagen> buscarImagenXUrl(String url);
	
	List<DatosImagen> obtenerDatosImagen();

	public void eliminarImagen(Long id);




}

