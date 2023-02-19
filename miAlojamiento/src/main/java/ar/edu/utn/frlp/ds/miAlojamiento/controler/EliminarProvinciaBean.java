package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;

/**
 * Clase Bean del Eliminar de Provincia
 * 
 * @author Mauro
 *
 */
@Named("eliminaProvinciaBean")
@ViewScoped
public class EliminarProvinciaBean extends GenericBean {

	@Value("${eliminaProvincia}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatoProvincia> datosCombo;
	private Provincia Provincia;

	@Autowired
	private ServicioProvinciaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarProvinciaBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosProvincia());
		setIdSeleccionado(null);
		setProvincia(null);
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

	public List<DatoProvincia> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatoProvincia> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia Provincia) {
		this.Provincia = Provincia;
	}

	public ServicioProvinciaImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioProvinciaImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Provincia por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaProvincia() {
		if(idSeleccionado != null) {
			setProvincia(servicio.buscarProvinciaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un provincia de la BD y muestra msj de exito
	 */
	public void eliminaProvincia() {
		if(idSeleccionado != null) {
			servicio.eliminarProvincia(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
