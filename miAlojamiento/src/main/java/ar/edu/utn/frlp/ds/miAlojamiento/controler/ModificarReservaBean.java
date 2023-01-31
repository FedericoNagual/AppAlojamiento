package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosReserva;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioReservaImpl;

/**
 * Clase Bean del Modificar de Reserva
 * 
 * @author Mauro
 *
 */
@Named("modificaReservaBean")
@ViewScoped
public class ModificarReservaBean extends GenericBean {

	@Value("${modificaReserva}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosReserva> datosCombo;
	private Reserva Reserva;

	@Autowired
	private ServicioReservaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaReservaBean que setea a la clase
	 * Reserva creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosReserva());
		setIdSeleccionado(null);
		setReserva(null);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 */
	public void consultaReserva() {
		if(idSeleccionado != null) {
			setReserva(servicio.buscarReservaXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Reserva de la BD y muestra un msj del cambio
	 */
	public void modificarReserva() {
		Reserva resultado = servicio.guardarReserva(getReserva());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}