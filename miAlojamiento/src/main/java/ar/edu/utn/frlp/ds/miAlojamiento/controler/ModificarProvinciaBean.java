package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;

/**
 * Clase Bean del Modificar de Provincia
 * 
 * @author Mauro
 *
 */
@Named("modificaProvinciaBean")
@ViewScoped
public class ModificarProvinciaBean extends GenericBean {

	@Value("${modificaProvincia}")
	private String nombre;

	private Long idSeleccionado;
	private List<DatoProvincia> datosCombo;
	private Provincia Provincia;

	@Autowired
	private ServicioProvinciaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaProvinciaBean que setea a la clase
	 * Provincia creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosProvincia());
		setIdSeleccionado(null);
		setProvincia(null);
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

	public List<DatoProvincia> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatoProvincia> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia Provincia) {
		this.Provincia = Provincia;
	}

	public ServicioProvinciaImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioProvinciaImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Provincia por id y lo almacena en idSeleccionado
	 */
	public void consultaProvincia() {
		if(idSeleccionado != null) {
			setProvincia(servicio.buscarProvinciaXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Provincia de la BD y muestra un msj del cambio
	 */
	public void modificarProvincia() {
		Provincia resultado = servicio.guardarProvincia(getProvincia());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}