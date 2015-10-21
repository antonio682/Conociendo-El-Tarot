package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class InicioBean implements Serializable {

	private static final long serialVersionUID = 1L;


	public InicioBean() {
	}

	public String irPresentacionNormal() {

		return "presentacionTiradaNormal.xhtml?faces-redirect=true";
	}

	public String irPresentacionPresente() {

		return "presentacionTiradaPresente?faces-redirect=true";
	}

	public String irPresentacionSi() {

		return "presentacionTiradaSi?faces-redirect=true";
	}

	public String irInicio() {

		return "presentacionTiradaInicio?faces-redirect=true";
	}
}
