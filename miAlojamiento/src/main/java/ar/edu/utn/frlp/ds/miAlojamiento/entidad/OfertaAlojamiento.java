package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
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
 * Modelo de la clase OfertaAlojamiento con sus atributos
 * 
 * @author Mauro
 *
 */
@Entity(name = "OfertaAlojamiento")
@Table(name = "OfertaAlojamiento")
public class OfertaAlojamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofertaAlojamientoId", unique = true, nullable = false)
	private Long id;

	@OneToMany
	@JoinColumn(name = "alojamientoId")
	private List<Alojamiento> listaAlojamiento;

	@OneToMany
	@JoinColumn(name = "ofertaId")
	private List<Oferta> listaOferta;

	public OfertaAlojamiento(Long id, List<Alojamiento> listaAlojamiento, List<Oferta> listaOferta) {
		super();
		this.id = id;
		this.listaAlojamiento = listaAlojamiento;
		this.listaOferta = listaOferta;
	}

	public OfertaAlojamiento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Alojamiento> getListaAlojamiento() {
		return listaAlojamiento;
	}

	public void setListaAlojamiento(List<Alojamiento> listaAlojamiento) {
		this.listaAlojamiento = listaAlojamiento;
	}

	public List<Oferta> getListaOferta() {
		return listaOferta;
	}

	public void setListaOferta(List<Oferta> listaOferta) {
		this.listaOferta = listaOferta;
	}

	@Override
	public String toString() {
		return "OfertaAlojamiento [id=" + id + ", listaAlojamiento=" + listaAlojamiento + ", listaOferta=" + listaOferta
				+ "]";
	}

}