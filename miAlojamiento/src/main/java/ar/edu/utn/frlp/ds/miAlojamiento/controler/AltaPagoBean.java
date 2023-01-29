package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPagoImpl;


/**
 * 
 * @author 
 *
 */
@Named("altaPagoBean")
@ViewScoped
public class AltaPagoBean extends GenericBean {

	@Value("${altaPago}")
	private Long id;
	private Pago pago;

	@Autowired
	private ServicioPagoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaPagoBean que setea a la clase
	 * Pago creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setPago(new Pago());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	
	/**
	 * Guarda una entity Pago y muestra un msj con los resultados
	 */
	public void guardarPago() {
		Pago resultado = servicio.guardarPago(getPago());
		mostrarMensaje("Se creó el pago  con el ID: " + resultado.getId());
		init();
	}

}
