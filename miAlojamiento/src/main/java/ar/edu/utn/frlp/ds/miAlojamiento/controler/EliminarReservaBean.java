package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosReserva;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioReservaImpl;

/**
 * Clase Bean del Eliminar de Reserva
 * 
 * @author Mauro
 *
 */
@Named("eliminaReservaBean")
@ViewScoped
public class EliminarReservaBean extends GenericBean {

	@Value("${eliminaReserva}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosReserva> datosCombo;
	private Reserva Reserva;

	@Autowired
	private ServicioReservaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarReservaBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosReserva());
		setIdSeleccionado(null);
		setReserva(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosReserva> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosReserva> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Reserva getReserva() {
		return Reserva;
	}

	public void setReserva(Reserva Reserva) {
		this.Reserva = Reserva;
	}

	public ServicioReservaImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioReservaImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Reserva por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaReserva() {
		if(idSeleccionado != null) {
			setReserva(servicio.buscarReservaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un reserva de la BD y muestra msj de exito
	 */
	public void eliminaReserva() {
		if(idSeleccionado != null) {
			servicio.eliminarReserva(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
