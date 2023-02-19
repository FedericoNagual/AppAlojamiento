package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPaquete;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaqueteImpl;

/**
 * Clase Bean del Eliminar de Paquete
 * 
 * @author Mauro
 *
 */
@Named("eliminaPaqueteBean")
@ViewScoped
public class EliminarPaqueteBean extends GenericBean {

	@Value("${eliminaPaquete}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPaquete> datosCombo;
	private Paquete Paquete;

	@Autowired
	private ServicioPaqueteImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarPaqueteBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosPaquete());
		setIdSeleccionado(null);
		setPaquete(null);
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
	 * 
	 */
	public void consultaPaquete() {
		if(idSeleccionado != null) {
			setPaquete(servicio.buscarPaqueteXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un paquete de la BD y muestra msj de exito
	 */
	public void eliminaPaquete() {
		if(idSeleccionado != null) {
			servicio.eliminarPaquete(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
