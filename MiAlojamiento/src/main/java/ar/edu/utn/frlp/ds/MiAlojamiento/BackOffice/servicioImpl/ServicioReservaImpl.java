package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosReserva;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Reserva;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.ReservaRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioReserva;

public class ServicioReservaImpl implements ServicioReserva{

	@Autowired
	private ReservaRepository reservaRepository;

	/**
	 * Guarda la entity reserva
	 * 
	 */
	@Override
	public Reserva guardarReserva(Reserva reserva) {
		return reservaRepository.saveAndFlush(reserva);
	}

	/**
	 * Busca una entity reserva por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<reserva> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Reserva> buscarReservaXFechaInicio(String fechaInicio) {
		//Implementar metodo que devuelva todas las Reserva por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Reserva> listaGeneral = reservaRepository.findAll();
		List<Reserva> lista = new ArrayList<Reserva>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (fechaInicio.equals(listaGeneral.get(i).getFechaInicio())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity reserva por Id
	 * 
	 * @param id tipo Long
	 * @return reserva resultado del metodo findById
	 */
	@Override
	public Reserva buscarReservaXId(Long id) {
		return reservaRepository.findById(id).get();
	}

	/**
	 * Obtener DatosReserva
	 * 
	 * @return List<DatosReserva> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosReserva> obtenerDatosReserva() {
		return reservaRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity reserva de la BD
	 */
	@Override
	public void eliminarReserva(Long id) {
		reservaRepository.deleteById(id);
	}

	
	

}


