package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Oferta;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioOfertaImpl;


/**
 * 
 * @author 
 *
 */
@Named("altaOfertaBean")
@ViewScoped
public class AltaOfertaBean extends GenericBean {

	@Value("${altaOferta}")
	private String titulo;
	private Oferta Oferta;

	@Autowired
	private ServicioOfertaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaOfertaBean que setea a la clase
	 * Oferta creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setOferta(new Oferta());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Oferta getOferta() {
		return Oferta;
	}

	public void setOferta(Oferta Oferta) {
		this.Oferta = Oferta;
	}

	
	/**
	 * Guarda una entity Oferta y muestra un msj con los resultados
	 */
	public void guardarOferta() {
		Oferta resultado = servicio.guardarOferta(getOferta());
		mostrarMensaje("Se creó el Oferta  con el ID: " + resultado.getId());
		init();
	}

}
