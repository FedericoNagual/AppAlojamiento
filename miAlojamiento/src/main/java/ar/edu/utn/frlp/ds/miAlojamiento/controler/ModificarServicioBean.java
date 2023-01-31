package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosServicio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioServicioImpl;

/**
 * Clase Bean del Modificar de Servicio
 * 
 * @author Mauro
 *
 */
@Named("modificaServicioBean")
@ViewScoped
public class ModificarServicioBean extends GenericBean {

	@Value("${modificaServicio}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosServicio> datosCombo;
	private Servicio servicio;

	@Autowired
	private ServicioServicioImpl servicioS;

	/**
	 * Se llama cuando se inicia la clase AltaServicioBean que setea a la clase
	 * Servicio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicioS.obtenerDatosServicio());
		setIdSeleccionado(null);
		setServicio(null);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre= nombre;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosServicio> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosServicio> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public ServicioServicioImpl getServicioS() {
		return servicioS;
	}

	public void setServicioS(ServicioServicioImpl servicioS) {
		this.servicioS = servicioS;
	}

	/**
	 * Consulta de Servicio por id y lo almacena en idSeleccionado
	 */
	public void consultaServicio() {
		if(idSeleccionado != null) {
			setServicio(servicioS.buscarServicioXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Servicio de la BD y muestra un msj del cambio
	 */
	public void modificarServicio() {
		Servicio resultado = servicioS.guardarServicio(getServicio());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}