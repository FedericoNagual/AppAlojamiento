package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioCiudadImpl;


/**
 * Clase Bean del Consulta de Ciudad
 * 
 * @author Mauro
 *
 */
@Named("consultaCiudadBean")
@ViewScoped
public class ConsultaCiudadBean extends GenericBean {

	@Value("${consultaCiudad}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatoCiudad> datosCombo;
	private Ciudad ciudad;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Ciudad> lista;
	private Ciudad ciudadSeleccionada;

	@Autowired
	private ServicioCiudadImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaCiudadBean que setea a
	 * Ciudad creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosCiudad());
		setLista(servicio.buscarCiudadAll());
		setIdSeleccionado(null);
		setCiudad(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatoCiudad> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatoCiudad> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Ciudad> getLista() {
		return lista;
	}

	public void setLista(List<Ciudad> lista) {
		this.lista = lista;
	}

	public Ciudad getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}

	public void setCiudadSeleccionada(Ciudad ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}

	/**
	 * Consulta las Ciudades y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaCiudad() {
		if (idSeleccionado != null) {
			setCiudad(servicio.buscarCiudadXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalHabitacion() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setCiudad(null);
		setAceptarListado(Boolean.TRUE);
	}

}
