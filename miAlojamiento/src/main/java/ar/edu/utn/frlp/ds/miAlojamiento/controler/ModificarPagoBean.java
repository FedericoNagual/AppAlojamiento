package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPagoImpl;

/**
 * Clase Bean del Modificar de Pago
 * 
 * @author Mauro
 *
 */
@Named("modificaPagoBean")
@ViewScoped
public class ModificarPagoBean extends GenericBean {

	@Value("${modificaPago}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPago> datosCombo;
	private Pago pago;

	@Autowired
	private ServicioPagoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaPagoBean que setea a la clase
	 * Pago creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setDatosCombo(servicio.obtenerDatosPago());
		setIdSeleccionado(null);
		setPago(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosPago> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPago> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago Pago) {
		this.pago = Pago;
	}

	public ServicioPagoImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPagoImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Pago por id y lo almacena en idSeleccionado
	 */
	public void consultaPago() {
		if(idSeleccionado != null) {
			setPago(servicio.buscarPagoXId(getIdSeleccionado()));
		}
	}
	
	/**
	 * Modifica  una Pago de la BD y muestra un msj del cambio
	 */
	public void modificarPago() {
		Pago resultado = servicio.guardarPago(getPago());
		mostrarMensaje("Cambios realizados con exito! para el registro N: " + resultado.getId());
	}

}