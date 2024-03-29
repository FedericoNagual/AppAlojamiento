package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;

/**
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("altaProvinciaBean")
@ViewScoped
public class AltaProvinciaBean extends GenericBean {

	@Value("${altaProvincia}")
	private String titulo;

	private Provincia provincia;
	private List<DatosPais> datosCombo;

	@Autowired
	private ServicioProvinciaImpl servicioProv;
	@Autowired
	private ServicioPaisImpl servicioPais;

	/**
	 * Se llama cuando se inicia la clase AltaProvinciaBean que setea a la clase
	 * Provincia creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setProvincia(new Provincia());
		setDatosCombo(servicioPais.obtenerDatosComboPais());
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

	public List<DatosPais> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPais> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public ServicioProvinciaImpl getServicio() {
		return servicioProv;
	}

	public void setServicio(ServicioProvinciaImpl servicio) {
		this.servicioProv = servicio;
	}

	public ServicioPaisImpl getServicioPais() {
		return servicioPais;
	}

	public void setServicioPais(ServicioPaisImpl servicioPais) {
		this.servicioPais = servicioPais;
	}

	/**
	 * Guarda una entity Provincia y muestra un msj con los resultados
	 */
	public void guardarProvincia() {
		Boolean isGuardar= true;
		isGuardar= validarDatos();
		if (isGuardar) {
			try {
				Provincia resultado = servicioProv.guardarProvincia(getProvincia());
				mostrarMensaje("Se creó la Provincia: " + resultado.getNombre() + " con el ID: " + resultado.getId());
			} catch (Exception e) {
				mostrarMensajeError("Error : "+e.toString());
			}
		}
		init();
	}
	
	private Boolean validarDatos() {
		Boolean flak=true;
		if (this.provincia == null || this.provincia.getNombre() == null || this.provincia.getPais().getId()== null) {
			mostrarMensajeFatal("Completar los datos por favor");
			flak=false;
		}
		return flak;
		
	}

}
