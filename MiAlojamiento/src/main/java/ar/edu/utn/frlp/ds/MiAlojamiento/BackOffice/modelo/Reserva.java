package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author 
 * 
 * Modelo de la clase Reserva con sus atributos
 *
 */
@Entity(name = "Reserva")
@Table(name = "Reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservaId", unique = true, nullable = false)
	private Long id;

	@Column(name = "servicio")
	private String servicio;

	@Column(name = "usuarioId")
	private Usuario usuario;

	@Column(name = "fechaInicio")
	private DateTime fechaInicio;

	@Column(name = "fechaFin")
	private DateTime fechaFin;

	@Column(name = "pagoId")
	private Pago pago;

	@Column(name = "paqueteId")
	private Paquete paquete;


	

	public Reserva(Long id, String servicio, Usuario usuario, DateTime fechaInicio, DateTime fechaFin, Pago pago,
			Paquete paquete) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.usuario = usuario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.pago = pago;
		this.paquete = paquete;
	}
	
	public Reserva() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(DateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public DateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(DateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", servicio=" + servicio + ", usuario=" + usuario + ", pago=" + pago + ", paquete="
				+ paquete + "]";
	}
	
	
}