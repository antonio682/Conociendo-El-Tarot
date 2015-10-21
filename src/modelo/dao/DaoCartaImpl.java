package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import entidades.Carta;

@Component
public class DaoCartaImpl implements DaoCarta {

	@PersistenceContext
	EntityManager em;

	@Override
	public Carta recuperarCartaxId(int idCarta) {

		return em.find(Carta.class, idCarta);

	}

	@Override
	public List<Carta> recuperarCartas() {
		Query q = em.createNamedQuery("Carta.findAll");

		return q.getResultList();
	}

}
