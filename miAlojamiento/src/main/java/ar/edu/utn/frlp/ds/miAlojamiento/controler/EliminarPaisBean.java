package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;

/**
 * Clase Bean del Eliminar de Pais
 * 
 * @author Mauro
 *
 */
@Named("eliminaPaisBean")
@ViewScoped
public class EliminarPaisBean extends GenericBean {

	@Value("${eliminaPais}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPais> datosCombo;
	private Pais Pais;

	@Autowired
	private ServicioPaisImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarPaisBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosComboPais());
		setIdSeleccionado(null);
		setPais(null);
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

	public List<DatosPais> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPais> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Pais getPais() {
		return Pais;
	}

	public void setPais(Pais Pais) {
		this.Pais = Pais;
	}

	public ServicioPaisImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPaisImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Pais por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaPais() {
		if(idSeleccionado != null) {
			setPais(servicio.buscarPaisXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un pais de la BD y muestra msj de exito
	 */
	public void eliminaPais() {
		if(idSeleccionado != null) {
			servicio.eliminarPais(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
