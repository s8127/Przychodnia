package com.przychodnia.manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.przychodnia.main.Lekarz;

public class LekarzManager {
	@PersistenceContext
	EntityManager em;
	
	public void addLekarz(Lekarz lekarz){
		em.persist(lekarz);
	}
	
	public void deleteLekarz(Lekarz lekarz){
		Lekarz l=em.find(Lekarz.class, lekarz.getId());
		em.remove(l);
	}
	

}
