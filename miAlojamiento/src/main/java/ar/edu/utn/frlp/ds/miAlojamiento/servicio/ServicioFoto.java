package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosFoto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;



public interface ServicioFoto {

	public Foto guardarFoto(Foto foto);

	public Foto buscarFotoXId(Long id);


	public List<Foto> buscarFotoXUrl(String url);
	
	public List<DatosFoto> obtenerDatosFoto();

	public void eliminarFoto(Long id);


	public List<Foto> buscarFotoAll();


}
