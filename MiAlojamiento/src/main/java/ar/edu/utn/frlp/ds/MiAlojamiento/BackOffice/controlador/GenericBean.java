package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;



/**
 * 
 * @author Federico
 * Clase generica que controla las acciones del los beans
 *
 */
public abstract class GenericBean {
	
	public void volver() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("/home.xhtml");
	}

	public void mostrarPopUp(String id) {
		PrimeFaces.current().executeScript("PF('" + id + "').show();");
	}

	public void mostrarMensaje(String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

}
