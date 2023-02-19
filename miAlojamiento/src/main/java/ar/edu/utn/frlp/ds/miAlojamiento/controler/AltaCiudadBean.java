package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioCiudadImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaCiudadBean")
@ViewScoped
public class AltaCiudadBean extends GenericBean {

	@Value("${altaCiudad}")
	private String titulo;

	private Ciudad ciudad;

	@Autowired
	private ServicioCiudadImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaCiudadBean que setea a la clase
	 * Ciudad creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setCiudad(new Ciudad());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * Guarda una entity Ciudad y muestra un msj con los resultados
	 */
	public void guardarCiudad() {
		Ciudad resultado = servicio.guardarCiudad(getCiudad());
		mostrarMensaje("Se creó la Ciudad: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
