package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioReservaImpl;

/**
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("altaReservaBean")
@ViewScoped
public class AltaReservaBean extends GenericBean {

	@Value("${altaReserva}")
	private String titulo;

	private Reserva reserva;

	@Autowired
	private ServicioReservaImpl servicioReser;

	/**
	 * Se llama cuando se inicia la clase AltaReservaBean que setea a la clase
	 * Reserva creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setReserva(new Reserva());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	/**
	 * Guarda una entity Reserva y muestra un msj con los resultados
	 */
	public void guardarReserva() {
		Reserva resultado = servicioReser.guardarReserva(getReserva());
		mostrarMensaje("Se creó la Reserva: " + resultado.getId());
		init();
	}

}
