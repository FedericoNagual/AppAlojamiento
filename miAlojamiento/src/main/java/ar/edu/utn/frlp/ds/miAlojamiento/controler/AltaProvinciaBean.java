package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaProvinciaBean")
@ViewScoped
public class AltaProvinciaBean extends GenericBean {

	@Value("${altaProvincia}")
	private String titulo;

	private Provincia provincia;

	@Autowired
	private ServicioProvinciaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaProvinciaBean que setea a la clase
	 * Provincia creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setProvincia(new Provincia());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	/**
	 * Guarda una entity Provincia y muestra un msj con los resultados
	 */
	public void guardarProvincia() {
		Provincia resultado = servicio.guardarProvincia(getProvincia());
		mostrarMensaje("Se creó la Provincia: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
