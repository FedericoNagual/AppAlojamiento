package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioDomicilioImpl;

/**
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("altaDomicilioBean")
@ViewScoped
public class AltaDomicilioBean extends GenericBean {

	@Value("${altaDomicilio}")
	private String titulo;

	private Domicilio Domicilio;

	@Autowired
	private ServicioDomicilioImpl servicioDomi;

	/**
	 * Se llama cuando se inicia la clase AltaDomicilioBean que setea a la clase
	 * Domicilio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDomicilio(new Domicilio());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		Domicilio resultado = servicioDomi.guardarDomicilio(getDomicilio());
		mostrarMensaje("Se creó la Domicilio: " + resultado.getCalle() + " con el ID: " + resultado.getId());
		init();
	}

}
