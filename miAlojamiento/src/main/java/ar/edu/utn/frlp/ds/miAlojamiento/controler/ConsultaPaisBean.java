package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;

/**
 * Implementacion del Servicio Pais
 * 
 * @author Mauro
 *
 */
@Named("consultaPaisBean")
@ViewScoped
public class ConsultaPaisBean extends GenericBean{
	@Value("${consultaPais}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosPais> datosCombo;
	private Pais pais;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Pais> lista;
	private Pais paisSeleccionado;

	@Autowired
	private ServicioPaisImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaPaisBean que setea a
	 * Pais creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosComboPais());
		setLista(servicio.buscarPaisAll());
		setIdSeleccionado(null);
		setPais(null);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Pais> getLista() {
		return lista;
	}

	public void setLista(List<Pais> lista) {
		this.lista = lista;
	}

	public Pais getPaisSeleccionada() {
		return paisSeleccionado;
	}

	public void setPaisSeleccionada(Pais paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}

	/**
	 * Consulta los paises y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaPais() {
		if (idSeleccionado != null) {
			setPais(servicio.buscarPaisXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalPais() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setPais(null);
		setAceptarListado(Boolean.TRUE);
	}
}
