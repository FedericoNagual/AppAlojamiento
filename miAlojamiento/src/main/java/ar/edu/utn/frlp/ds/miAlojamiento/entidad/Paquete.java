package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Paquete con sus atributos
 * 
 * @author Mauro
 * 
 *
 */
@Entity(name = "Paquete")
@Table(name = "Paquete")
public class Paquete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paqueteId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "cantidadDias")
	private Long cantidadDias;

	@Column(name = "cantidadNoches")
	private Long cantidadNoches;

	@Column(name = "imagenId")
	private Imagen imagen;

	@Column(name = "alojamientoId")
	private Alojamiento alojamiento;

	public Paquete(Long id, String nombre, String descripcion, Long cantidadDias, Long cantidadNoches, Imagen imagen,
			Alojamiento alojamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadDias = cantidadDias;
		this.cantidadNoches = cantidadNoches;
		this.imagen = imagen;
		this.alojamiento = alojamiento;
	}

	public Paquete() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Long cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Long getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(Long cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	@Override
	public String toString() {
		return "Paquete [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidadDias="
				+ cantidadDias + ", cantidadNoches=" + cantidadNoches + ", imagen=" + imagen + ", alojamiento="
				+ alojamiento + "]";
	}

}