package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosHabitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioHabitacionImpl;

/**
 * Clase Bean del Consulta de Habitacion
 * 
 * @author Federico
 *
 */
@Named("consultaHabitacionBean")
@ViewScoped
public class ConsultaHabitacionBean extends GenericBean {

	@Value("${consultaHabitacion}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosHabitacion> datosCombo;
	private Habitacion habitacion;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Habitacion> lista;
	private Habitacion habSeleccionada;

	@Autowired
	private ServicioHabitacionImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaHabitacionBean que setea a
	 * Habitacion creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosComboHabitacion());
		setLista(servicio.buscarHabitacionAll());
		setIdSeleccionado(null);
		setHabitacion(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosHabitacion> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosHabitacion> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Habitacion> getLista() {
		return lista;
	}

	public void setLista(List<Habitacion> lista) {
		this.lista = lista;
	}

	public Habitacion getHabSeleccionada() {
		return habSeleccionada;
	}

	public void setHabSeleccionada(Habitacion habSeleccionada) {
		this.habSeleccionada = habSeleccionada;
	}

	/**
	 * Consulta las habitaciones y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaHabitacion() {
		if (idSeleccionado != null) {
			setHabitacion(servicio.buscarHabitacionXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalHabitacion() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setHabitacion(null);
		setAceptarListado(Boolean.TRUE);
	}

}
