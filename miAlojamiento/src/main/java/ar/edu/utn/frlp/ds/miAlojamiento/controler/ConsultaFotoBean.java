package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosFoto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioFotoImpl;

/**
 * Clase Bean del Consulta de Foto
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("consultaFotoBean")
@ViewScoped
public class ConsultaFotoBean extends GenericBean {

	@Value("${consultaFoto}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosFoto> datosCombo;
	private Foto Foto;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Foto> lista;
	private Foto fotoSeleccionada;

	@Autowired
	private ServicioFotoImpl servicioFoto;

	/**
	 * Se llama cuando se inicia la clase ConsutaFotoBean que setea a Foto creando
	 * una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicioFoto.obtenerDatosFoto());
		setLista(servicioFoto.buscarFotoAll());
		setIdSeleccionado(null);
		setFoto(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Foto getFoto() {
		return Foto;
	}

	public void setFoto(Foto Foto) {
		this.Foto = Foto;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosFoto> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosFoto> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Foto> getLista() {
		return lista;
	}

	public void setLista(List<Foto> lista) {
		this.lista = lista;
	}

	public Foto getFotoSeleccionada() {
		return fotoSeleccionada;
	}

	public void setFotoSeleccionada(Foto fotoSeleccionada) {
		this.fotoSeleccionada = fotoSeleccionada;
	}

	/**
	 * Consulta las Fotos y busca sus datos por el Id seleccionado y los muestra en
	 * la vista
	 */
	public void consultaFoto() {
		if (idSeleccionado != null) {
			setFoto(servicioFoto.buscarFotoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalFoto() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setFoto(null);
		setAceptarListado(Boolean.TRUE);
	}

}
