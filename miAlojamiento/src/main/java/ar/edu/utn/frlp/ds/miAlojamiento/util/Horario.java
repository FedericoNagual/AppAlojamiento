package ar.edu.utn.frlp.ds.miAlojamiento.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase guarda horario del dia para elegir de una lista
 * 
 * @author Federico
 *
 */
public class Horario {

	private List<Long> listaHorarios;

	public Horario(List<Long> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}

	public Horario() {
		setListaHorarios(new ArrayList<Long>());
		generarHorarios();
	}

	public List<Long> getListaHorarios() {
		return listaHorarios;
	}

	public void setListaHorarios(List<Long> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}

	private void generarHorarios() {
		for (int i = 0; i < 25; i++) {
			Long hora = new Long(i);
			listaHorarios.add(hora);
			
		}
	}

}
