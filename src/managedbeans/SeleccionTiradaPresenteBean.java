package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import entidades.Carta;
import modelo.service.ServiceCarta;

@ManagedBean
@SessionScoped
public class SeleccionTiradaPresenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{gestionServiceCarta}")
	ServiceCarta cartaService;

	@ManagedProperty("#{presentacionTiradaPresenteBean}")
	PresentacionTiradaPresenteBean pt;

	private List<Carta> mazo;
	private List<Carta> cartasSeleccionadas;
	private int contador = 0;

	public SeleccionTiradaPresenteBean() {
	}

	@PostConstruct
	public void init() {

		mazo = cartaService.findCartas();
		Collections.shuffle(mazo);
		cartasSeleccionadas = new ArrayList<Carta>();

	}

	/*
	 * public void onCardDrop(DragDropEvent ddEvent) { Carta carta = ((Carta)
	 * ddEvent.getData());
	 * 
	 * cartasSeleccionadas.add(carta); mazo.remove(carta);
	 * 
	 * }
	 */
	public String irResultado() {
		if (contador == 3) {
			return "resultadoTiradaPresente?faces-redirect=true";
		} else {
			return null;
		}
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		Carta car = ((Carta) ddEvent.getData());
		if (cartasSeleccionadas.isEmpty() == true || cartasSeleccionadas.size() <= 2) {
			cartasSeleccionadas.add(car);
			mazo.remove(car);
			contador++;
		} else {
			System.out.println("Array lleno");
		}

	}

	public ServiceCarta getCartaService() {
		return cartaService;
	}

	public void setCartaService(ServiceCarta cartaService) {
		this.cartaService = cartaService;
	}

	public List<Carta> getMazo() {
		return mazo;
	}

	public void setMazo(List<Carta> mazo) {
		this.mazo = mazo;
	}

	public List<Carta> getCartasSeleccionadas() {
		return cartasSeleccionadas;
	}

	public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
		this.cartasSeleccionadas = cartasSeleccionadas;
	}

	public PresentacionTiradaPresenteBean getPt() {
		return pt;
	}

	public void setPt(PresentacionTiradaPresenteBean pt) {
		this.pt = pt;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
