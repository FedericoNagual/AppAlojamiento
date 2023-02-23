package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioCiudadImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;

/**
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("altaCiudadBean")
@ViewScoped
public class AltaCiudadBean extends GenericBean {

	@Value("${altaCiudad}")
	private String titulo;

	private Ciudad ciudad;
	private List<DatoProvincia> datoCombo;

	@Autowired
	private ServicioCiudadImpl servicio;
	private ServicioProvinciaImpl servicioProv;

	/**
	 * Se llama cuando se inicia la clase AltaCiudadBean que setea a la clase Ciudad
	 * creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setCiudad(new Ciudad());
		setDatoCombo(servicioProv.obtenerDatosProvincia());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<DatoProvincia> getDatoCombo() {
		return datoCombo;
	}

	public void setDatoCombo(List<DatoProvincia> datoCombo) {
		this.datoCombo = datoCombo;
	}

	public ServicioCiudadImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioCiudadImpl servicio) {
		this.servicio = servicio;
	}

	public ServicioProvinciaImpl getServicioProv() {
		return servicioProv;
	}

	public void setServicioProv(ServicioProvinciaImpl servicioProv) {
		this.servicioProv = servicioProv;
	}

	/**
	 * Guarda una entity Ciudad y muestra un msj con los resultados
	 */
	public void guardarCiudad() {
		Ciudad resultado = servicio.guardarCiudad(getCiudad());
		mostrarMensaje("Se creó la Ciudad: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
