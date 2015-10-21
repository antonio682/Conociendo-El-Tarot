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
public class ResultadoTirandaNormalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{seleccionTiradaNormalBean}")
	SeleccionTiradaNormalBean stn;
	
	@ManagedProperty("#{presentacionTiradaNormalBean}")
	PresentacionTiradaNormalBean pt;

	private List<Carta> cartasSeleccionadas;
	private List<CartaResultadoTipo> resultadoFinal;

	public ResultadoTirandaNormalBean() {
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

			if (contador < 3) {

				if (modulo != 0) {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenNormal());
					carta.setSignificado(c.getSpan());
				} else {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenInvertida());
					carta.setSignificado(c.getSpai());
				}
				System.out.println("pasado"+ contador);
				resultadoFinal.add(carta);

			} else if (contador >= 3 && contador < 6) {
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
				System.out.println("presente" + contador);

			} else if (contador >= 6 && contador < 9) {

				if (modulo != 0) {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenNormal());
					carta.setSignificado(c.getSfun());
					System.out.println("futuroooo normal");
				} else {
					carta.setNombre(c.getNombre());
					carta.setImagen(c.getImagenInvertida());
					carta.setSignificado(c.getSfui());
					System.out.println("futuroooo invertido");
				}
				resultadoFinal.add(carta);
				System.out.println("futuroooo" + contador);

			} else  {

				carta.setNombre(c.getNombre());
				carta.setImagen(c.getImagenNormal());
				carta.setSignificado(c.getSregente());
				System.out.println("regenteeeeeeee" +contador);

				resultadoFinal.add(carta);
			}
			contador++;
		}
	}

	public String invalidarSesion() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "presentacionTiradaNormal?faces-redirect=true";

	}

	public List<Carta> getCartasSeleccionadas() {
		return cartasSeleccionadas;
	}

	public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
		this.cartasSeleccionadas = cartasSeleccionadas;
	}

	public SeleccionTiradaNormalBean getStn() {
		return stn;
	}

	public void setStn(SeleccionTiradaNormalBean stn) {
		this.stn = stn;
	}

	public List<CartaResultadoTipo> getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(List<CartaResultadoTipo> resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public PresentacionTiradaNormalBean getPt() {
		return pt;
	}

	public void setPt(PresentacionTiradaNormalBean pt) {
		this.pt = pt;
	}

}
