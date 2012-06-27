package com.przychodnia.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.przychodnia.main.Pacjent;

public class PacjentManager {
	@PersistenceContext
	EntityManager em;
	
	public void addPacjent(Pacjent pacjent){
		em.persist(pacjent);
	}
	
	public void deletePacjent(Pacjent pacjent){
		Pacjent p=em.find(Pacjent.class, pacjent.getId());
		em.remove(p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pacjent> getAllPacjent(){
		return em.createNamedQuery("pacjent.all").getResultList();
	}

}
