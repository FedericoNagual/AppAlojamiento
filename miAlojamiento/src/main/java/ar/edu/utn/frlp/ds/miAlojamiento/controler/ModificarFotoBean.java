package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosFoto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioFotoImpl;

/**
 * Clase Bean del Modificar de Foto
 * 
 * @author Mauro
 *
 */
@Named("modificaFotoBean")
@ViewScoped
public class ModificarFotoBean extends GenericBean {

	@Value("${modificaFoto}")
	private String url;

	private Long idSeleccionado;
	private List<DatosFoto> datosCombo;
	private Foto Foto;

	@Autowired
	private ServicioFotoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaFotoBean que setea a la clase
	 * Foto creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosFoto());
		setIdSeleccionado(null);
		setFoto(null);
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
	 */
	public void consultaFoto() {
		if(idSeleccionado != null) {
			setFoto(servicio.buscarFotoXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Foto de la BD y muestra un msj del cambio
	 */
	public void modificarFoto() {
		Foto resultado = servicio.guardarFoto(getFoto());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}