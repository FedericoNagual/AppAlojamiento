package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosAlojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioAlojamientoImpl;



/**
 * Implementacion del Servicio Alojamiento
 * 
 * @author Mauro
 *
 */
@Named("consultaAlojamientoBean")
@ViewScoped
public class ConsultaAlojamientoBean extends GenericBean{
	@Value("${consultaAlojamiento}")
	private String name;

	private Long idSeleccionado;
	private List<DatosAlojamiento> datosCombo;
	private Alojamiento alojamiento;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Alojamiento> lista;
	private Alojamiento alojamientoSeleccionado;

	@Autowired
	private ServicioAlojamientoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaAlojamientoBean que setea a
	 * Alojamiento creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosAlojamiento());
		setLista(servicio.buscarAlojamientoAll());
		setIdSeleccionado(null);
		setAlojamiento(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosAlojamiento> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosAlojamiento> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Alojamiento> getLista() {
		return lista;
	}

	public void setLista(List<Alojamiento> lista) {
		this.lista = lista;
	}

	public Alojamiento getAlojamientoSeleccionado() {
		return alojamientoSeleccionado;
	}

	public void setAlojamientoSeleccionado(Alojamiento alojamientoSeleccionado) {
		this.alojamientoSeleccionado = alojamientoSeleccionado;
	}

	/**
	 * Consulta los paises y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaAlojamiento() {
		if (idSeleccionado != null) {
			setAlojamiento(servicio.buscarAlojamientoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalAlojamiento() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setAlojamientoSeleccionado(null);
		setAceptarListado(Boolean.TRUE);
	}
}
