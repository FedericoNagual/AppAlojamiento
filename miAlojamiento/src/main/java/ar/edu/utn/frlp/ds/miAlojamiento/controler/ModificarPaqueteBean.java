package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPaquete;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaqueteImpl;

/**
 * Clase Bean del Modificar de Paquete
 * 
 * @author Mauro
 *
 */
@Named("modificaPaqueteBean")
@ViewScoped
public class ModificarPaqueteBean extends GenericBean {

	@Value("${modificaPaquete}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosPaquete> datosCombo;
	private Paquete Paquete;

	@Autowired
	private ServicioPaqueteImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaPaqueteBean que setea a la clase
	 * Paquete creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosPaquete());
		setIdSeleccionado(null);
		setPaquete(null);
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

	public List<DatosPaquete> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPaquete> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Paquete getPaquete() {
		return Paquete;
	}

	public void setPaquete(Paquete Paquete) {
		this.Paquete = Paquete;
	}

	public ServicioPaqueteImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPaqueteImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Paquete por id y lo almacena en idSeleccionado
	 */
	public void consultaPaquete() {
		if(idSeleccionado != null) {
			setPaquete(servicio.buscarPaqueteXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Paquete de la BD y muestra un msj del cambio
	 */
	public void modificarPaquete() {
		Paquete resultado = servicio.guardarPaquete(getPaquete());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}