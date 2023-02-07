package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosServicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioServicioImpl;

/**
 * Clase Bean del Eliminar de Servicio
 * 
 * @author Mauro
 *
 */
@Named("eliminaServicioBean")
@ViewScoped
public class EliminarServicioBean extends GenericBean {

	@Value("${eliminaServicio}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosServicio> datosCombo;
	private Servicio Servicio;

	@Autowired
	private ServicioServicioImpl servicioI;

	/**
	 * Se llama cuando se inicia la clase EliminarServicioBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicioI.obtenerDatosServicio());
		setIdSeleccionado(null);
		setServicio(null);
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

	public List<DatosServicio> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosServicio> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Servicio getServicio() {
		return Servicio;
	}

	public void setServicio(Servicio Servicio) {
		this.Servicio = Servicio;
	}

	public ServicioServicioImpl getServicioI() {
		return servicioI;
	}

	public void setServicioI(ServicioServicioImpl servicioI) {
		this.servicioI = servicioI;
	}

	/**
	 * Consulta de Servicio por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaServicio() {
		if(idSeleccionado != null) {
			setServicio(servicioI.buscarServicioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un servicio de la BD y muestra msj de exito
	 */
	public void eliminaServicio() {
		if(idSeleccionado != null) {
			servicioI.eliminarServicio(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
