package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import beans.CartaResultadoTipo;
import entidades.Carta;

@ManagedBean
@SessionScoped
public class ResultadoTirandaPresenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{seleccionTiradaPresenteBean}")
	SeleccionTiradaPresenteBean stn;

	@ManagedProperty("#{presentacionTiradaPresenteBean}")
	PresentacionTiradaPresenteBean pb;

	private List<Carta> cartasSeleccionadas;
	private List<CartaResultadoTipo> resultadoFinal;

	public ResultadoTirandaPresenteBean() {
	}

	@PostConstruct
	public void init() {

		cartasSeleccionadas = stn.getCartasSeleccionadas();
		resultadoFinal = new ArrayList<>();

		Random numero;
		int modulo;
		int contador = 0;
		CartaResultadoTipo carta;
		for (Carta c : cartasSeleccionadas) {

			numero = new Random();
			modulo = numero.nextInt() % 2;
			carta = new CartaResultadoTipo();

			if (contador == 0) {

				if (modulo != 0) {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenNormal());
					carta.setSignificado(c.getSpan());
				} else {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenInvertida());
					carta.setSignificado(c.getSpai());
				}

				resultadoFinal.add(carta);

			} else if (contador == 1) {
				if (modulo != 0) {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenNormal());
					carta.setSignificado(c.getSpen());
				} else {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenInvertida());
					carta.setSignificado(c.getSpei());
				}

				resultadoFinal.add(carta);

			} else if (contador == 2) {

				if (modulo != 0) {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenNormal());
					carta.setSignificado(c.getSfun());
				} else {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenInvertida());
					carta.setSignificado(c.getSfui());
				}
				resultadoFinal.add(carta);

			}
			contador++;
		}
	}

	public String invalidarSesion() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "presentacionTiradaPresente?faces-redirect=true";

	}

	public List<Carta> getCartasSeleccionadas() {
		return cartasSeleccionadas;
	}

	public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
		this.cartasSeleccionadas = cartasSeleccionadas;
	}

	public SeleccionTiradaPresenteBean getStn() {
		return stn;
	}

	public void setStn(SeleccionTiradaPresenteBean stn) {
		this.stn = stn;
	}

	public List<CartaResultadoTipo> getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(List<CartaResultadoTipo> resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public PresentacionTiradaPresenteBean getPb() {
		return pb;
	}

	public void setPb(PresentacionTiradaPresenteBean pb) {
		this.pb = pb;
	}

}
