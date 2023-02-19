package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosFoto;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioFotoImpl;

/**
 * Clase Bean del Eliminar de Foto
 * 
 * @author Mauro
 *
 */
@Named("eliminaFotoBean")
@ViewScoped
public class EliminarFotoBean extends GenericBean {

	@Value("${eliminaFoto}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosFoto> datosCombo;
	private Foto Foto;

	@Autowired
	private ServicioFotoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarFotoBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosFoto());
		setIdSeleccionado(null);
		setFoto(null);
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

	public List<DatosFoto> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosFoto> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Foto getFoto() {
		return Foto;
	}

	public void setFoto(Foto Foto) {
		this.Foto = Foto;
	}

	public ServicioFotoImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioFotoImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Foto por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaFoto() {
		if(idSeleccionado != null) {
			setFoto(servicio.buscarFotoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un foto de la BD y muestra msj de exito
	 */
	public void eliminaFoto() {
		if(idSeleccionado != null) {
			servicio.eliminarFoto(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
