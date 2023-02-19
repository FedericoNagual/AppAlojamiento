package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioUsuarioImpl;

/**
 * Clase Bean del Modificar de Usuario
 * 
 * @author Mauro
 *
 */
@Named("modificaUsuarioBean")
@ViewScoped
public class ModificarUsuarioBean extends GenericBean {

	@Value("${modificaUsuario}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosUsuario> datosCombo;
	private Usuario Usuario;

	@Autowired
	private ServicioUsuarioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaUsuarioBean que setea a la clase
	 * Usuario creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosUsuario());
		setIdSeleccionado(null);
		setUsuario(null);
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
	 */
	public void consultaUsuario() {
		if(idSeleccionado != null) {
			setUsuario(servicio.buscarUsuarioXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Usuario de la BD y muestra un msj del cambio
	 */
	public void modificarUsuario() {
		Usuario resultado = servicio.guardarUsuario(getUsuario());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}