package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPago;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pago;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.PagoRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioPago;

public class ServicioPagoImpl implements ServicioPago{
	@Autowired
	private PagoRepository PagoRepository;

	/**
	 * Guarda la entity Pago
	 * 
	 */
	@Override
	public Pago guardarPago(Pago Pago) {
		return PagoRepository.saveAndFlush(Pago);
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
		List<Pago> listaGeneral = PagoRepository.findAll();
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
		return PagoRepository.findById(id).get();
	}

	/**
	 * Obtener DatosPago
	 * 
	 * @return List<DatosPago> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosPago> obtenerDatosPago() {
		return PagoRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Pago de la BD
	 */
	@Override
	public void eliminarPago(Long id) {
		PagoRepository.deleteById(id);
	}

	
	

}



