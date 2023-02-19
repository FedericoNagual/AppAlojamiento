package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioImagenImpl;

/**
 * Clase Bean del Alta de Imagen
 * @author Federico
 *
 */
@Named("altaImagenBean")
@ViewScoped
public class AltaImagenBean extends GenericBean {

	@Value("${altaImagen}")
	private String titulo;

	private Imagen Imagen;

	@Autowired
	private ServicioImagenImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaImagenBean que setea a la clase
	 * Imagen creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setImagen(new Imagen());
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

	/**
	 * Guarda una entity Imagen y muestra un msj con los resultados
	 */
	public void guardarImagen() {
		Imagen resultado = servicio.guardarImagen(getImagen());
		mostrarMensaje("Se creó la Imagen: " + resultado.getUrl() + " con el ID: " + resultado.getId());
		init();
	}

}