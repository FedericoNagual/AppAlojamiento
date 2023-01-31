package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioRolImpl;

/**
 * Clase Bean del Modificar de Rol
 * 
 * @author Mauro
 *
 */
@Named("modificaRolBean")
@ViewScoped
public class ModificarRolBean extends GenericBean {

	@Value("${modificaRol}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosRol> datosCombo;
	private Rol Rol;

	@Autowired
	private ServicioRolImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaRolBean que setea a la clase
	 * Rol creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosRol());
		setIdSeleccionado(null);
		setRol(null);
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
	 */
	public void consultaRol() {
		if(idSeleccionado != null) {
			setRol(servicio.buscarRolXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Rol de la BD y muestra un msj del cambio
	 */
	public void modificarRol() {
		Rol resultado = servicio.guardarRol(getRol());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}