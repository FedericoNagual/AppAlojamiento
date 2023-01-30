package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosDomicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioDomicilioImpl;


/**
 * Clase Bean del Consulta de Domicilio
 * 
 * @author Mauro
 *
 */
@Named("consultaDomicilioBean")
@ViewScoped
public class ConsultaDomicilioBean extends GenericBean {

	@Value("${consultaDomicilio}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosDomicilio> datosCombo;
	private Domicilio Domicilio;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Domicilio> lista;
	private Domicilio DomicilioSeleccionada;

	@Autowired
	private ServicioDomicilioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaDomicilioBean que setea a
	 * Domicilio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosDomicilio());
		setLista(servicio.buscarDomicilioAll());
		setIdSeleccionado(null);
		setDomicilio(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio Domicilio) {
		this.Domicilio = Domicilio;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosDomicilio> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosDomicilio> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Domicilio> getLista() {
		return lista;
	}

	public void setLista(List<Domicilio> lista) {
		this.lista = lista;
	}

	public Domicilio getDomicilioSeleccionada() {
		return DomicilioSeleccionada;
	}

	public void setDomicilioSeleccionada(Domicilio DomicilioSeleccionada) {
		this.DomicilioSeleccionada = DomicilioSeleccionada;
	}

	/**
	 * Consulta las Domicilioes y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaDomicilio() {
		if (idSeleccionado != null) {
			setDomicilio(servicio.buscarDomicilioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalDomicilio() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setDomicilio(null);
		setAceptarListado(Boolean.TRUE);
	}

}
