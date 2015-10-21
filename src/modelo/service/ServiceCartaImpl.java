package modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entidades.Carta;
import modelo.dao.DaoCarta;

@Component(value="gestionServiceCarta")
public class ServiceCartaImpl implements ServiceCarta {
	
	@Autowired
	DaoCarta daoCarta;
	

	@Override
	public Carta findCartaXId(int id) {
		
		return daoCarta.recuperarCartaxId(id);
	}

	@Override
	public List<Carta> findCartas() {
		
		return daoCarta.recuperarCartas();
	}

}
