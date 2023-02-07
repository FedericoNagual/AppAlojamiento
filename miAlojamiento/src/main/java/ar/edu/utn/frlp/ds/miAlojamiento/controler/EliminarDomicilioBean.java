package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosDomicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioDomicilioImpl;

/**
 * Clase Bean del Eliminar de Domicilio
 * 
 * @author Mauro
 *
 */
@Named("eliminaDomicilioBean")
@ViewScoped
public class EliminarDomicilioBean extends GenericBean {

	@Value("${eliminaDomicilio}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosDomicilio> datosCombo;
	private Domicilio Domicilio;

	@Autowired
	private ServicioDomicilioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarDomicilioBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosDomicilio());
		setIdSeleccionado(null);
		setDomicilio(null);
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

	public List<DatosDomicilio> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosDomicilio> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio Domicilio) {
		this.Domicilio = Domicilio;
	}

	public ServicioDomicilioImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDomicilioImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Domicilio por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaDomicilio() {
		if(idSeleccionado != null) {
			setDomicilio(servicio.buscarDomicilioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un domicilio de la BD y muestra msj de exito
	 */
	public void eliminaDomicilio() {
		if(idSeleccionado != null) {
			servicio.eliminarDomicilio(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
