package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosFoto;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Foto;


public interface ServicioFoto {

	public Foto guardarFoto(Foto foto);

	public Foto buscarFotoXId(Long id);


	public List<Foto> buscarFotoXUrl(String url);
	
	List<DatosFoto> obtenerDatosFoto();

	public void eliminarFoto(Long id);




}
