package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosImagen;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioImagenImpl;


/**
 * Clase Bean del Consulta de Imagen
 * 
 * @author Mauro
 *
 */
@Named("consultaImagenBean")
@ViewScoped
public class ConsultaImagenBean extends GenericBean {

	@Value("${consultaImagen}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosImagen> datosCombo;
	private Imagen Imagen;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Imagen> lista;
	private Imagen ImagenSeleccionada;

	@Autowired
	private ServicioImagenImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaImagenBean que setea a
	 * Imagen creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosImagen());
		setLista(servicio.buscarImagenAll());
		setIdSeleccionado(null);
		setImagen(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Imagen getImagen() {
		return Imagen;
	}

	public void setImagen(Imagen Imagen) {
		this.Imagen = Imagen;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosImagen> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosImagen> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Imagen> getLista() {
		return lista;
	}

	public void setLista(List<Imagen> lista) {
		this.lista = lista;
	}

	public Imagen getImagenSeleccionada() {
		return ImagenSeleccionada;
	}

	public void setImagenSeleccionada(Imagen ImagenSeleccionada) {
		this.ImagenSeleccionada = ImagenSeleccionada;
	}

	/**
	 * Consulta las Imagenes y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaImagen() {
		if (idSeleccionado != null) {
			setImagen(servicio.buscarImagenXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalImagen() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setImagen(null);
		setAceptarListado(Boolean.TRUE);
	}

}
