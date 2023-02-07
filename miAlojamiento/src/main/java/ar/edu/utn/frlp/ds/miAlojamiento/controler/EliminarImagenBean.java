package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosImagen;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioImagenImpl;

/**
 * Clase Bean del Eliminar de Imagen
 * 
 * @author Mauro 
 * 
 * */
@Named("eliminaImagenBean")
@ViewScoped
public class EliminarImagenBean extends GenericBean {

	@Value("${eliminaImagen}")
	private String url;

	private Long idSeleccionado;
	private List<DatosImagen> datosCombo;
	private Imagen Imagen;

	@Autowired
	private ServicioImagenImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarImagenBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosImagen());
		setIdSeleccionado(null);
		setImagen(null);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosImagen> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosImagen> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Imagen getImagen() {
		return Imagen;
	}

	public void setImagen(Imagen Imagen) {
		this.Imagen = Imagen;
	}

	public ServicioImagenImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioImagenImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Imagen por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaImagen() {
		if(idSeleccionado != null) {
			setImagen(servicio.buscarImagenXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un imagen de la BD y muestra msj de exito
	 */
	public void eliminaImagen() {
		if(idSeleccionado != null) {
			servicio.eliminarImagen(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
