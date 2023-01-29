package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosHabitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioHabitacionImpl;

/**
 * Clase Bean del Eliminar de Habitacion
 * 
 * @author Federico
 *
 */
@Named("eliminaHabitacionBean")
@ViewScoped
public class EliminarHabitacionBean extends GenericBean {

	@Value("${eliminaHabitacion}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosHabitacion> datosCombo;
	private Habitacion habitacion;

	@Autowired
	private ServicioHabitacionImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarHabitacionBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosComboHabitacion());
		setIdSeleccionado(null);
		setHabitacion(null);
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

	public List<DatosHabitacion> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosHabitacion> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public ServicioHabitacionImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioHabitacionImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Habitacion por id y lo almacena en idSeleccionado
	 */
	public void consultaHabitacion() {
		if(idSeleccionado != null) {
			setHabitacion(servicio.buscarHabitacionXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un vehiculo de la BD y muestra msj de exito
	 */
	public void eliminaHabitacion() {
		if(idSeleccionado != null) {
			servicio.eliminarHabitacion(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
