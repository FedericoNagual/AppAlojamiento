package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioUsuarioImpl;

/**
 * Clase Bean del Eliminar de Usuario
 * 
 * @author Mauro
 *
 */
@Named("eliminaUsuarioBean")
@ViewScoped
public class EliminarUsuarioBean extends GenericBean {

	@Value("${eliminaUsuario}")
	private String dni;

	private Long idSeleccionado;
	private List<DatosUsuario> datosCombo;
	private Usuario Usuario;

	@Autowired
	private ServicioUsuarioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarUsuarioBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosUsuario());
		setIdSeleccionado(null);
		setUsuario(null);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosUsuario> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosUsuario> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public ServicioUsuarioImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioUsuarioImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Usuario por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaUsuario() {
		if(idSeleccionado != null) {
			setUsuario(servicio.buscarUsuarioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un usuario de la BD y muestra msj de exito
	 */
	public void eliminaUsuario() {
		if(idSeleccionado != null) {
			servicio.eliminarUsuario(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
