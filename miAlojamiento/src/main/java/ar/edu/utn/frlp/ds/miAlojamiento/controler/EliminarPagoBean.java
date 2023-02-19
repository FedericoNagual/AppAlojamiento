package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPagoImpl;

/**
 * Clase Bean del Eliminar de Pago
 * 
 * @author Mauro
 *
 */
@Named("eliminaPagoBean")
@ViewScoped
public class EliminarPagoBean extends GenericBean {

	@Value("${eliminaPago}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPago> datosCombo;
	private Pago Pago;

	@Autowired
	private ServicioPagoImpl servicio;

	/**
	 * Se llama cuando se inicia la clase EliminarPagoBean que setea los datos
	 * para usar y carga el combo box para seleccionar elq ue desea eliminar
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
		return Pago;
	}

	public void setPago(Pago Pago) {
		this.Pago = Pago;
	}

	public ServicioPagoImpl getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPagoImpl servicio) {
		this.servicio = servicio;
	}

	/**
	 * Consulta de Pago por id y lo almacena en idSeleccionado
	 * 
	 */
	public void consultaPago() {
		if(idSeleccionado != null) {
			setPago(servicio.buscarPagoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Elimina un pago de la BD y muestra msj de exito
	 */
	public void eliminaPago() {
		if(idSeleccionado != null) {
			servicio.eliminarPago(getIdSeleccionado());
			mostrarMensaje("Eliminacion con exito");
		}
		init();
	}

}
