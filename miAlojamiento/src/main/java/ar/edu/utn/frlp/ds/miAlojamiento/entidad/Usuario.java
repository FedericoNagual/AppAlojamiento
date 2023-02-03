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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Usuario con sus atributos
 * 
 * @author Mauro
 * 
 *
 */
@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "FechaNacimiento")
	private Date fechaNacimiento;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "Telefono")
	private Long telefono;

	@Column(name = "TipoDocumento")
	private String tipoDocumento;
	
	@OneToOne
	@JoinColumn(name = "domicilioId")
	private Domicilio domicilio;
	
	@OneToMany
	@JoinColumn(name = "reservaId")
	private List<Reserva> listaReserva;

	@OneToMany
	@JoinColumn(name = "loginId")
	private List<Login> listaLogin;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, Date fechaNacimiento, String dni, Long telefono, String tipoDocumento,
			Domicilio domicilio, List<Reserva> listaReserva, List<Login> listaLogin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.telefono = telefono;
		this.tipoDocumento = tipoDocumento;
		this.domicilio = domicilio;
		this.listaReserva = listaReserva;
		this.listaLogin = listaLogin;
	}

	public List<Login> getListaLogin() {
		return listaLogin;
	}

	public void setListaLogin(List<Login> listaLogin) {
		this.listaLogin = listaLogin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni
				+ ", telefono=" + telefono + ", tipoDocumento=" + tipoDocumento + ", domicilio=" + domicilio + "]";
	}
}