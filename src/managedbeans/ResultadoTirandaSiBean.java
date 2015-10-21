package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import beans.CartaResultadoTipo;
import entidades.Carta;

@ManagedBean
@SessionScoped
public class ResultadoTirandaSiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{seleccionTiradaSiBean}")
	SeleccionTiradaSiBean stn;
	
	@ManagedProperty("#{presentacionTiradaSiBean}")
	PresentacionTiradaSiBean ps;
	
	private List<Carta> cartasSeleccionadas;
	private List<CartaResultadoTipo> resultadoFinal;

	public ResultadoTirandaSiBean() {
	}

	@PostConstruct
	public void init() {

		cartasSeleccionadas = stn.getCartasSeleccionadas();
		resultadoFinal = new ArrayList<>();

		int contador = 0;
		CartaResultadoTipo carta;
		for (Carta c : cartasSeleccionadas) {

			carta = new CartaResultadoTipo();

			if (contador < 1) {

				carta.setNombre(c.getNombre());
				carta.setImagen(c.getImagenNormal());
				carta.setSignificado(c.getSsn());

				resultadoFinal.add(carta);
				contador++;
			}
		}
	}

	public String invalidarSesion() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "presentacionTiradaSi?faces-redirect=true";

	}

	public List<Carta> getCartasSeleccionadas() {
		return cartasSeleccionadas;
	}

	public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
		this.cartasSeleccionadas = cartasSeleccionadas;
	}

	public SeleccionTiradaSiBean getStn() {
		return stn;
	}

	public void setStn(SeleccionTiradaSiBean stn) {
		this.stn = stn;
	}

	public List<CartaResultadoTipo> getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(List<CartaResultadoTipo> resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public PresentacionTiradaSiBean getPs() {
		return ps;
	}

	public void setPs(PresentacionTiradaSiBean ps) {
		this.ps = ps;
	}
	

}
