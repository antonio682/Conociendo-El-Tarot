package modelo.service;

import java.util.List;

import entidades.Carta;

public interface ServiceCarta {

	public Carta findCartaXId(int id );
	public List<Carta> findCartas();
	
}
