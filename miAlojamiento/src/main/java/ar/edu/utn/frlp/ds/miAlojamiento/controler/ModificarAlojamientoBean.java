package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosAlojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioAlojamientoImpl;

/**
 * Clase Bean del Modificar de Alojamiento
 * 
 * @author Mauro
 *
 */
@Named("modificaAlojamientoBean")
@ViewScoped
public class ModificarAlojamientoBean extends GenericBean {

	@Value("${modificaAlojamiento}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosAlojamiento> datosCombo;
	private Alojamiento Alojamiento;

	@Autowired
	private ServicioAlojamientoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaAlojamientoBean que setea a la clase
	 * Alojamiento creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosAlojamiento());
		setIdSeleccionado(null);
		setAlojamiento(null);
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
	 */
	public void consultaAlojamiento() {
		if(idSeleccionado != null) {
			setAlojamiento(servicio.buscarAlojamientoXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Alojamiento de la BD y muestra un msj del cambio
	 */
	public void modificarAlojamiento() {
		Alojamiento resultado = servicio.guardarAlojamiento(getAlojamiento());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}