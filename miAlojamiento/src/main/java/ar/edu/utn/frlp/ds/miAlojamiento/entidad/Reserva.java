package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Reserva con sus atributos
 * 
 * @author Mauro
 * 
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

	@Column(name = "fechaInicio")
	private Date fechaInicio;

	@Column(name = "fechaFin")
	private Date fechaFin;

	@OneToMany
	@JoinColumn(name = "paqueteId")
	private List<Paquete> listaPaquete;

	public Reserva(Long id, String servicio, Date fechaInicio, Date fechaFin, List<Paquete> listaPaquete) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.listaPaquete = listaPaquete;
	}

	public Reserva() {
		super();
	}

	public List<Paquete> getListaPaquete() {
		return listaPaquete;
	}

	public void setListaPaquete(List<Paquete> listaPaquete) {
		this.listaPaquete = listaPaquete;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", servicio=" + servicio + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", listaPaquete=" + listaPaquete + "]";
	}

}