package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Ciudad;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Provincia;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl.ServicioCiudadImpl;
import jakarta.annotation.PostConstruct;

/**
 * 
 * @author 
 *
 */
@Named("altaCiudadBean")
@ViewScoped
public class AltaCiudadBean extends GenericBean {

	@Value("${altaCiudad}")
	private String nombre;

	private Provincia provincia;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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
