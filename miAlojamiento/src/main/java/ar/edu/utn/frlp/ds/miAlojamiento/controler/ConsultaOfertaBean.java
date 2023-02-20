package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosOferta;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioOfertaImpl;

/**
 * Clase Bean del Consulta de Oferta
 * 
 * @author Mauro
 *
 */
@Named("consultaOfertaBean")
@ViewScoped
public class ConsultaOfertaBean extends GenericBean {

	@Value("${consultaOferta}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosOferta> datosCombo;
	private Oferta Oferta;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Oferta> lista;
	private Oferta OfertaSeleccionado;

	@Autowired
	private ServicioOfertaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaOfertaBean que setea a
	 * Oferta creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosOferta());
		setLista(servicio.buscarOfertaAll());
		setIdSeleccionado(null);
		setOferta(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Oferta getOferta() {
		return Oferta;
	}

	public void setOferta(Oferta Oferta) {
		this.Oferta = Oferta;
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

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Oferta> getLista() {
		return lista;
	}

	public void setLista(List<Oferta> lista) {
		this.lista = lista;
	}

	public Oferta getOfertaSeleccionado() {
		return OfertaSeleccionado;
	}

	public void setOfertaSeleccionado(Oferta OfertaSeleccionado) {
		this.OfertaSeleccionado = OfertaSeleccionado;
	}

	/**
	 * Consulta las Ofertas y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaOferta() {
		if (idSeleccionado != null) {
			setOferta(servicio.buscarOfertaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalOferta() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setOferta(null);
		setAceptarListado(Boolean.TRUE);
	}

}
