package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pais;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Provincia;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl.ServicioProvinciaImpl;
import jakarta.annotation.PostConstruct;

/**
 * 
 * @author 
 *
 */
@Named("altaProvinciaBean")
@ViewScoped
public class AltaProvinciaBean extends GenericBean {

	@Value("${altaCiudad}")
	private String nombre;

	private Provincia provincia;
	private Pais pais;

	@Autowired
	private ServicioProvinciaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaProvinciaBean que setea a la clase
	 * Ciudad creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setProvincia(new Provincia());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Pais getPais() {
		return pais;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	/**
	 * Guarda una entity Provincia y muestra un msj con los resultados
	 */
	public void guardarProvincia() {
		Provincia resultado = servicio.guardarProvincia(getProvincia());
		mostrarMensaje("Se creó la Ciudad: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
