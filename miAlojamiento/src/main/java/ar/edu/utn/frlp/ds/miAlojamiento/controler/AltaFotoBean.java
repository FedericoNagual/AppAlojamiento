package ar.edu.utn.frlp.ds.miAlojamiento.controler;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioFotoImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaFotoBean")
@ViewScoped
public class AltaFotoBean extends GenericBean {

	@Value("${altaFoto}")
	private String url;

	private String extension;
	private Foto foto;

	@Autowired
	private ServicioFotoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaFotoBean que setea a la clase
	 * Foto creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setFoto(new Foto());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * Guarda una entity Foto y muestra un msj con los resultados
	 */
	public void guardarFoto() {
		Foto resultado = servicio.guardarFoto(getFoto());
		mostrarMensaje("Se creó la Foro: " + resultado.getUrl() + " con el ID: " + resultado.getId());
		init();
	}

}
