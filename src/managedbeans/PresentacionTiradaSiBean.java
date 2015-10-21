package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class PresentacionTiradaSiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * @ManagedProperty("#{gUsuarioService}") UsuarioService userS;
	 */

	private String nombre;

	public PresentacionTiradaSiBean() {
	}

	public String irSeleccionCartasNormal() {
		
		return "selecccionTiradaNormal";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
