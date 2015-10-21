package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carta database table.
 * 
 */
@Entity
@NamedQuery(name="Carta.findAll", query="SELECT c FROM Carta c")
public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarta;

	private String imagenInvertida;

	private String imagenNormal;

	private String nombre;

	private String sfui;

	private String sfun;

	private String spai;

	private String span;

	private String spei;

	private String spen;

	private String sregente;

	private String ssn;

	public Carta() {
	}

	public int getIdCarta() {
		return this.idCarta;
	}

	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}

	public String getImagenInvertida() {
		return this.imagenInvertida;
	}

	public void setImagenInvertida(String imagenInvertida) {
		this.imagenInvertida = imagenInvertida;
	}

	public String getImagenNormal() {
		return this.imagenNormal;
	}

	public void setImagenNormal(String imagenNormal) {
		this.imagenNormal = imagenNormal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSfui() {
		return this.sfui;
	}

	public void setSfui(String sfui) {
		this.sfui = sfui;
	}

	public String getSfun() {
		return this.sfun;
	}

	public void setSfun(String sfun) {
		this.sfun = sfun;
	}

	public String getSpai() {
		return this.spai;
	}

	public void setSpai(String spai) {
		this.spai = spai;
	}

	public String getSpan() {
		return this.span;
	}

	public void setSpan(String span) {
		this.span = span;
	}

	public String getSpei() {
		return this.spei;
	}

	public void setSpei(String spei) {
		this.spei = spei;
	}

	public String getSpen() {
		return this.spen;
	}

	public void setSpen(String spen) {
		this.spen = spen;
	}

	public String getSregente() {
		return this.sregente;
	}

	public void setSregente(String sregente) {
		this.sregente = sregente;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}