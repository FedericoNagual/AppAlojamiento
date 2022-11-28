package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Foto;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl.ServicioFotoImpl;
import jakarta.annotation.PostConstruct;

/**
 * 
 * @author 
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
	 * Se llama cuando se inicia la clase AltaCiudadBean que setea a la clase
	 * Ciudad creando una nueva instancia
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
	 * Guarda una entity Ciudad y muestra un msj con los resultados
	 */
	public void guardarCiudad() {
		Foto resultado = servicio.guardarFoto(getFoto());
		mostrarMensaje("Se creó la Foro: " + resultado.getUrl() + " con el ID: " + resultado.getId());
		init();
	}

}
