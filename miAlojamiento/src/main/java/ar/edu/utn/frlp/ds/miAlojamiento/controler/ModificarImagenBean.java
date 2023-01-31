package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosImagen;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Imagen;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioImagenImpl;

/**
 * Clase Bean del Modificar de Imagen
 * 
 * @author Mauro
 *
 */
@Named("modificaImagenBean")
@ViewScoped
public class ModificarImagenBean extends GenericBean {

	@Value("${modificaImagen}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatosImagen> datosCombo;
	private Imagen Imagen;

	@Autowired
	private ServicioImagenImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaImagenBean que setea a la clase
	 * Imagen creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosImagen());
		setIdSeleccionado(null);
		setImagen(null);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosImagen> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosImagen> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Imagen getImagen() {
		return Imagen;
	}

	public void setImagen(Imagen Imagen) {
		this.Imagen = Imagen;
	}

	public ServicioImagenImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioImagenImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Imagen por id y lo almacena en idSeleccionado
	 */
	public void consultaImagen() {
		if(idSeleccionado != null) {
			setImagen(servicio.buscarImagenXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Imagen de la BD y muestra un msj del cambio
	 */
	public void modificarImagen() {
		Imagen resultado = servicio.guardarImagen(getImagen());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}