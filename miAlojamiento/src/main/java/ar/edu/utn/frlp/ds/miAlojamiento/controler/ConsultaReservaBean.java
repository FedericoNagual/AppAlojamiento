package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosReserva;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioReservaImpl;


/**
 * Implementacion del Servicio Reserva
 * 
 * @author Mauro
 *
 */
@Named("consultaReservaBean")
@ViewScoped
public class ConsultaReservaBean extends GenericBean{
	@Value("${consultaProvincia}")
	private Reserva reserva;
	private Long idSeleccionado;
	private List<DatosReserva> datosCombo;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Reserva> lista;
	private Reserva reservaSeleccionada;

	@Autowired
	private ServicioReservaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaReservaBean que setea a
	 * Reserva creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosReserva());
		setLista(servicio.buscarReservaAll());
		setIdSeleccionado(null);
		setReserva(null);
	}


	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Reserva> getLista() {
		return lista;
	}

	public void setLista(List<Reserva> lista) {
		this.lista = lista;
	}

	public Reserva  getReservaSeleccionada() {
		return reservaSeleccionada;
	}

	public void setReservaSeleccionada(Reserva reservaSeleccionada) {
		this.reservaSeleccionada = reservaSeleccionada;
	}

	/**
	 * Consulta las Reserva y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaProvincia() {
		if (idSeleccionado != null) {
			setReserva(servicio.buscarReservaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalReserva() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setReserva(null);
		setAceptarListado(Boolean.TRUE);
	}
}
