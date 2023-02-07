package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioRolImpl;

/**
 * Clase Bean del Eliminar de Rol
 * 
 * @author Mauro
 *
 */
@Named("eliminaRolBean")
@ViewScoped
public class EliminarRolBean extends GenericBean {

	@Value("${eliminaRol}")
	private String descripcion;

	private Long idSeleccionado;
	private List<DatosRol> datosCombo;
	private Rol Rol;

	@Autowired
	private ServicioRolImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarRolBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosRol());
		setIdSeleccionado(null);
		setRol(null);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosRol> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosRol> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol Rol) {
		this.Rol = Rol;
	}

	public ServicioRolImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioRolImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Rol por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaRol() {
		if(idSeleccionado != null) {
			setRol(servicio.buscarRolXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un rol de la BD y muestra msj de exito
	 */
	public void eliminaRol() {
		if(idSeleccionado != null) {
			servicio.eliminarRol(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
