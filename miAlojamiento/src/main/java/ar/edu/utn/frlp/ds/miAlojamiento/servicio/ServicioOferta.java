package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.Date;
import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosOferta;

/**
 * 
 * @author Federico
 *
 */
public interface ServicioOferta {

	public Oferta guardarOferta(Oferta Oferta);

	public Oferta buscarOfertaXId(Long id);

	public List<Oferta> buscarOfertaXFechaInicio(Date fechaInicio);

	public List<DatosOferta> obtenerDatosOferta();

	public void eliminarOferta(Long id);

	public List<Oferta> buscarOfertaAll();

}