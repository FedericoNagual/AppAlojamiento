package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioRolImpl;

/**
 * Clase Bean del Alta de Rol
 * @author Federico
 *
 */
@Named("altaRolBean")
@ViewScoped
public class AltaRolBean extends GenericBean {

	@Value("${altaRol}")
	private String titulo;

	private Rol Rol;

	@Autowired
	private ServicioRolImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaRolBean que setea a la clase
	 * Rol creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setRol(new Rol());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol Rol) {
		this.Rol = Rol;
	}

	/**
	 * Guarda una entity Rol y muestra un msj con los resultados
	 */
	public void guardarRol() {
		Rol resultado = servicio.guardarRol(getRol());
		mostrarMensaje("Se creó el Rol: " + resultado.getDescripcion() + " con el ID: " + resultado.getId());
		init();
	}

}