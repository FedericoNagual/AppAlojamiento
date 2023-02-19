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
	private String titulo;

	private Servicio servicio;

	@Autowired
	private ServicioServicioImpl servicioI;

	/**
	 * Se llama cuando se inicia la clase AltaServicioBean que setea a la clase
	 * Servicio creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setServicio(new Servicio());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
