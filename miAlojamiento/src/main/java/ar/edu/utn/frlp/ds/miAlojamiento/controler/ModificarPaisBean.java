package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;

/**
 * Clase Bean del Modificar de Pais
 * 
 * @author Mauro
 *
 */
@Named("modificaPaisBean")
@ViewScoped
public class ModificarPaisBean extends GenericBean {

	@Value("${modificaPais}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPais> datosCombo;
	private Pais Pais;

	@Autowired
	private ServicioPaisImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaPaisBean que setea a la clase
	 * Pais creando una nueva instancia
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
	 */
	public void consultaPais() {
		if(idSeleccionado != null) {
			setPais(servicio.buscarPaisXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Pais de la BD y muestra un msj del cambio
	 */
	public void modificarPais() {
		Pais resultado = servicio.guardarPais(getPais());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}
