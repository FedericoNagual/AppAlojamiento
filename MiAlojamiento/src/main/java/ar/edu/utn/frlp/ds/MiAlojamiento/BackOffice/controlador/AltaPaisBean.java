package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Habitacion;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pais;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl.ServicioPaisImpl;
import jakarta.annotation.PostConstruct;

@Named("altaPaisBean")
@ViewScoped
public class AltaPaisBean extends GenericBean {

	@Value("${altaPais}")
	private String nombre;
 
	private Pais pais;

	@Autowired
	private ServicioPaisImpl servicio;

	@PostConstruct
	public void init() {
		setPais(new Pais());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	/**
	 * Guarda una entity Pais y muestra un msj con los resultados
	 */
	public void guardarPais() {
		Pais resultado = servicio.guardarPais(getPais());
		mostrarMensaje("Se creó el Pais: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
