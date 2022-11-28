package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.io.Serializable;
import java.sql.Date;

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
 * Modelo de la clase Usuario con sus atributos
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

	@Column(name = "rolId")
	private Rol rol;
	
	@Column(name = "domicilioId")
	private Domicilio domicilio;	
	
	@Column(name = "FechaNacimiento")
	private Date  fechaNacimiento;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "Telefono")
	private Long telefono;
	
	@Column(name = "TipoDocumento")
	private String tipoDocumento;
	
	public Usuario(Long id, String nombre, Rol rol,Domicilio domicilio,Date fechaNacimiento,String dni,Long telefono,String tipoDocumento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
		this.telefono = telefono;
		this.tipoDocumento = tipoDocumento;
	}

	public Usuario() {
		super();
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + ", telefono=" + telefono + ", tipoDocumento=" + tipoDocumento +  "]";
	}
}