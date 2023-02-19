package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosAlojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioAlojamientoImpl;

/**
 * Clase Bean del Eliminar de Alojamiento
 * 
 * @author Mauro
 *
 */
@Named("eliminaAlojamientoBean")
@ViewScoped
public class EliminarAlojamientoBean extends GenericBean {

	@Value("${eliminaAlojamiento}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosAlojamiento> datosCombo;
	private Alojamiento Alojamiento;

	@Autowired
	private ServicioAlojamientoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarAlojamientoBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosAlojamiento());
		setIdSeleccionado(null);
		setAlojamiento(null);
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

	public List<DatosAlojamiento> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosAlojamiento> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Alojamiento getAlojamiento() {
		return Alojamiento;
	}

	public void setAlojamiento(Alojamiento Alojamiento) {
		this.Alojamiento = Alojamiento;
	}

	public ServicioAlojamientoImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioAlojamientoImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Alojamiento por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaAlojamiento() {
		if(idSeleccionado != null) {
			setAlojamiento(servicio.buscarAlojamientoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un alojamiento de la BD y muestra msj de exito
	 */
	public void eliminaAlojamiento() {
		if(idSeleccionado != null) {
			servicio.eliminarAlojamiento(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
