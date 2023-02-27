package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosDomicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;





public interface ServicioDomicilio {

	public Domicilio guardarDomicilio(Domicilio domicilio);

	public Domicilio buscarDomicilioXId(Long id);


	public List<Domicilio> buscarDomicilioXCalle(String calle);
	
	public List<DatosDomicilio> obtenerDatosDomicilio();

	public void eliminarDomicilio(Long id);


	public List<Domicilio> buscarDomicilioAll();


}