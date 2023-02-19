package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioCiudadImpl;

/**
 * Clase Bean del Eliminar de Ciudad
 * 
 * @author Mauro
 *
 */
@Named("eliminaCiudadBean")
@ViewScoped
public class EliminarCiudadBean extends GenericBean {

	@Value("${eliminaCiudad}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatoCiudad> datosCombo;
	private Ciudad Ciudad;

	@Autowired
	private ServicioCiudadImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarCiudadBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosCiudad());
		setIdSeleccionado(null);
		setCiudad(null);
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

	public List<DatoCiudad> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatoCiudad> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Ciudad getCiudad() {
		return Ciudad;
	}

	public void setCiudad(Ciudad Ciudad) {
		this.Ciudad = Ciudad;
	}

	public ServicioCiudadImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioCiudadImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Ciudad por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaCiudad() {
		if(idSeleccionado != null) {
			setCiudad(servicio.buscarCiudadXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un ciudad de la BD y muestra msj de exito
	 */
	public void eliminaCiudad() {
		if(idSeleccionado != null) {
			servicio.eliminarCiudad(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
