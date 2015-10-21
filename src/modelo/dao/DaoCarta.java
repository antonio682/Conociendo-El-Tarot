package modelo.dao;

import java.util.List;

import entidades.Carta;

public interface DaoCarta {
	
	public Carta recuperarCartaxId(int idCarta);
	public List<Carta>  recuperarCartas();

	
}
