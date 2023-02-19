package ar.edu.utn.frlp.ds.miAlojamiento.controler;


import java.sql.Time;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioAlojamientoImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaAlojamientoBean")
@ViewScoped
public class AltaAlojamientoBean extends GenericBean {
	@Value("${altaAlojamiento}")
	private String titulo;

	private Alojamiento alojamiento;

	@Autowired
	private ServicioAlojamientoImpl servicioI;

	/**
	 * Se llama cuando se inicia la clase AltaAlojamientoBean que setea a la clase
	 * Alojamiento creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAlojamiento(new Alojamiento());
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}


	/**
	 * Guarda una entity Alojamiento y muestra un msj con los resultados
	 */
	public void guardarAlojamiento() {
		Alojamiento resultado = servicioI.guardarAlojamiento(getAlojamiento());
		mostrarMensaje("Se creó el Alojamiento: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
