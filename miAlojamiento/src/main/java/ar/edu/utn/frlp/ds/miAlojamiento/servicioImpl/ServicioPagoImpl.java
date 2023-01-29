package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.PagoRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioPago;

/**
 * Implementacion del Servicio Pago
 * 
 * @author Mauro
 *
 */

@SessionScope
@Service
public class ServicioPagoImpl implements ServicioPago{
	@Autowired
	private PagoRepository pagoRepository;

	/**
	 * Guarda la entity Pago
	 * 
	 */
	@Override
	public Pago guardarPago(Pago Pago) {
		return pagoRepository.saveAndFlush(Pago);
	}

	/**
	 * Busca una entity Pago por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Pago> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Pago> buscarPagoXUltimosDigitos(String ultimosDigitos) {
		//Implementar metodo que devuelva todas las Pago por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Pago> listaGeneral = pagoRepository.findAll();
		List<Pago> lista = new ArrayList<Pago>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (ultimosDigitos.equals(listaGeneral.get(i).getUltimosDigitos())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Pago por Id
	 * 
	 * @param id tipo Long
	 * @return Pago resultado del metodo findById
	 */
	@Override
	public Pago buscarPagoXId(Long id) {
		return pagoRepository.findById(id).get();
	}

	/**
	 * Obtener DatosPago
	 * 
	 * @return List<DatosPago> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosPago> obtenerDatosPago() {
		return pagoRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Pago de la BD
	 */
	@Override
	public void eliminarPago(Long id) {
		pagoRepository.deleteById(id);
	}

	

	/**
	 * Busca todos las Tuplas de Pago que existen
	 * @return List<Pago> resultado del metodo findAll() 
	 */
	@Override
	public List<Pago> buscarPagoAll() {
		List<Pago> ListaCompleta= pagoRepository.findAll();
		return ListaCompleta;
	}

}



