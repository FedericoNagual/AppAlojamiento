package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosServicio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioServicioImpl;

/**
 * Implementacion del Servicio  
 * 
 * @author Mauro
 *
 */
@Named("consultaServicioBean")
@ViewScoped
public class ConsultaServicioBean extends GenericBean{
	@Value("${consultaPaquete}")
	private String name;
	private Servicio servicio;
	private Long idSeleccionado;
	private List<DatosServicio> datosCombo;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Servicio> lista;
	private Servicio servicioSeleccionado;

	@Autowired
	private ServicioServicioImpl servicios;

	/**
	 * Se llama cuando se inicia la clase ConsutaServicioBean que setea a
	 * Servicio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicios.obtenerDatosServicio());
		setLista(servicios.buscarServicioAll());
		setIdSeleccionado(null);
		setServicio(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosServicio> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosServicio> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Servicio> getLista() {
		return lista;
	}

	public void setLista(List<Servicio> lista) {
		this.lista = lista;
	}

	public Servicio  getServicioSeleccionado() {
		return servicioSeleccionado;
	}

	public void setServicioSeleccionado(Servicio servicioSeleccionado) {
		this.servicioSeleccionado = servicioSeleccionado;
	}

	/**
	 * Consulta los Servicios y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaPaquete() {
		if (idSeleccionado != null) {
			setServicio(servicios.buscarServicioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalServicio() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setServicio(null);
		setAceptarListado(Boolean.TRUE);
	}
}
