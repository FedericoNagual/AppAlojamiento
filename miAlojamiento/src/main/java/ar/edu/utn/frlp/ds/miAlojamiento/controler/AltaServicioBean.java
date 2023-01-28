package ar.edu.utn.frlp.ds.miAlojamiento.controler;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioServicioImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaServicioBean")
@ViewScoped
public class AltaServicioBean extends GenericBean {

	@Value("${altaServicio}")
	private String nombre;

	private Servicio servicio;

	@Autowired
	private ServicioServicioImpl servicioI;

	/**
	 * Se llama cuando se inicia la clase AltaProvinciaBean que setea a la clase
	 * Ciudad creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setServicio(new Servicio());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	/**
	 * Guarda una entity Servicio y muestra un msj con los resultados
	 */
	public void guardarServicio() {
		Servicio resultado = servicioI.guardarServicio(getServicio());
		mostrarMensaje("Se creó el servicio: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}


}
