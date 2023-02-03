package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioDomicilioImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaDomicilioBean")
@ViewScoped
public class AltaDomicilioBean extends GenericBean {

	@Value("${altaDomicilio}")
	private String nombre;

	private Ciudad ciudad;
	private Domicilio Domicilio;

	@Autowired
	private ServicioDomicilioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaDomicilioBean que setea a la clase
	 * Domicilio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDomicilio(new Domicilio());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio Domicilio) {
		this.Domicilio = Domicilio;
	}
	/**
	 * Guarda una entity Domicilio y muestra un msj con los resultados
	 */
	public void guardarDomicilio() {
		Domicilio resultado = servicio.guardarDomicilio(getDomicilio());
		mostrarMensaje("Se creó la Domicilio: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}