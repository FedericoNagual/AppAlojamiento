package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosOferta;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioOfertaImpl;

/**
 * Clase Bean del Eliminar de Oferta
 * 
 * @author Mauro
 *
 */
@Named("eliminaOfertaBean")
@ViewScoped
public class EliminarOfertaBean extends GenericBean {

	@Value("${eliminaOferta}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosOferta> datosCombo;
	private Oferta Oferta;

	@Autowired
	private ServicioOfertaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarOfertaBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosOferta());
		setIdSeleccionado(null);
		setOferta(null);
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

	public List<DatosOferta> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosOferta> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Oferta getOferta() {
		return Oferta;
	}

	public void setOferta(Oferta Oferta) {
		this.Oferta = Oferta;
	}

	public ServicioOfertaImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioOfertaImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Oferta por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaOferta() {
		if(idSeleccionado != null) {
			setOferta(servicio.buscarOfertaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un Oferta de la BD y muestra msj de exito
	 */
	public void eliminaOferta() {
		if(idSeleccionado != null) {
			servicio.eliminarOferta(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
