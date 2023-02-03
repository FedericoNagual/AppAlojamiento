package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.List;

/**
 * 
 * @author Mauro
 *
 */
public interface DatosPais {
	Long getId();

	String getNombre();
	
	List<Provincia> listaProvincia();

	default String getFormatoCombo() {
		return getNombre();
	}
}
