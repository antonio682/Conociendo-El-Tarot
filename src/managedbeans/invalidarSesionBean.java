package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@ManagedBean
@RequestScoped
public class invalidarSesionBean implements Serializable , ActionListener {

	private static final long serialVersionUID = 1L;

	public invalidarSesionBean() {
	}


	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
