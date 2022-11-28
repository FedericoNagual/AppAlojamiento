package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPais;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pais;

public interface ServicioPais {

		public Pais guardarPais(Pais pais);

		public Pais buscarPaisXId(Long id);


		public List<Pais> buscarPaisXNombre(String nombre);
		
		List<DatosPais> obtenerDatosPais();

		public void eliminarPais(Long id);


	

}
