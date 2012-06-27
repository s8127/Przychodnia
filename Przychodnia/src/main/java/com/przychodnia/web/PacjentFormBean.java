package com.przychodnia.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


import com.przychodnia.main.Pacjent;
import com.przychodnia.manager.PacjentManager;

@SessionScoped
@Named("pacjentBean")
public class PacjentFormBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Pacjent pacjent = new Pacjent();
	private ListDataModel<Pacjent> pacjenci = new ListDataModel<Pacjent>();

	@Inject
	private PacjentManager pm;

	public Pacjent getPacjent() {
		return pacjent;
	}

	public void setPacjent(Pacjent pacjent) {
		this.pacjent = pacjent;
	}

	public ListDataModel<Pacjent> getPacjenci() {
		return pacjenci;
	}
	
	public String addPacjent() {

		pm.addPacjent(pacjent);

		return "pokazPacjentow";
	}

	public String deletePacjent() {
		Pacjent p = pacjenci.getRowData();
		pm.deletePacjent(p);

		return "pokazPacjentow";
	}
	
	public List<Pacjent> getAllPacjent(){
		return pm.getAllPacjent();
	}
	

}
