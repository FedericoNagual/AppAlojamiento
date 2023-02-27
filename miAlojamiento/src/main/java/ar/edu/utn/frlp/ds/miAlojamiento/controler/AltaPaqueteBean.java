package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaqueteImpl;

@Named("altaPaqueteBean")
@ViewScoped
public class AltaPaqueteBean extends GenericBean {

	@Value("${altaPaquete}")
	private String titulo;
	private Paquete paquete;

	@Autowired
	private ServicioPaqueteImpl servicioPaque;

	@PostConstruct
	public void init() {
		setPaquete(new Paquete());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	/**
	 * Guarda una entity Paquete y muestra un msj con los resultados
	 */
	public void guardarPaquete() {
		Paquete resultado = servicioPaque.guardarPaquete(getPaquete());
		mostrarMensaje("Se creó el Paquete: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
