package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPaquete;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaqueteImpl;

/**
 * Implementacion del Servicio Paquete
 * 
 * @author Mauro
 *
 */
@Named("consultaPaqueteBean")
@ViewScoped
public class ConsultaPaqueteBean extends GenericBean{
	@Value("${consultaPaquete}")
	private String name;
	private Paquete paquete;
	private Long idSeleccionado;
	private List<DatosPaquete> datosCombo;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Paquete> lista;
	private Paquete paqueteSeleccionado;

	@Autowired
	private ServicioPaqueteImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaPaqueteBean que setea a
	 * Paquete creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosPaquete());
		setLista(servicio.buscarPaqueteAll());
		setIdSeleccionado(null);
		setPaquete(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}


	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosPaquete> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPaquete> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Paquete> getLista() {
		return lista;
	}

	public void setLista(List<Paquete> lista) {
		this.lista = lista;
	}

	public Paquete  getPaqueteSeleccionado() {
		return paqueteSeleccionado;
	}

	public void setPaqueteSeleccionado(Paquete paqueteSeleccionado) {
		this.paqueteSeleccionado = paqueteSeleccionado;
	}

	/**
	 * Consulta los Paquete y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaPaquete() {
		if (idSeleccionado != null) {
			setPaquete(servicio.buscarPaqueteXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalPaquete() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setPaquete(null);
		setAceptarListado(Boolean.TRUE);
	}
}
