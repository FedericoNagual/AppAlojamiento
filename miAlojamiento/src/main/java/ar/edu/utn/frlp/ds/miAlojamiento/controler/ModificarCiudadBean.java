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
 * Clase Bean del Modificar de Ciudad
 * 
 * @author Mauro
 *
 */
@Named("modificaCiudadBean")
@ViewScoped
public class ModificarCiudadBean extends GenericBean {

	@Value("${modificaCiudad}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatoCiudad> datosCombo;
	private Ciudad Ciudad;

	@Autowired
	private ServicioCiudadImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaCiudadBean que setea a la clase
	 * Ciudad creando una nueva instancia
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
	 */
	public void consultaCiudad() {
		if(idSeleccionado != null) {
			setCiudad(servicio.buscarCiudadXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Ciudad de la BD y muestra un msj del cambio
	 */
	public void modificarCiudad() {
		Ciudad resultado = servicio.guardarCiudad(getCiudad());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}