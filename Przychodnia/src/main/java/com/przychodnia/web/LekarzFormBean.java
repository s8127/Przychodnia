package com.przychodnia.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.przychodnia.main.Lekarz;
import com.przychodnia.manager.LekarzManager;



@SessionScoped
@Named("lekarzBean")
public class LekarzFormBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Lekarz lekarz = new Lekarz();
	private ListDataModel<Lekarz> lekarze = new ListDataModel<Lekarz>();

	@Inject
	private LekarzManager lm;

	public Lekarz getLekarz() {
		return lekarz;
	}

	public void setLekarz(Lekarz lekarz) {
		this.lekarz = lekarz;
	}

	public ListDataModel<Lekarz> getLekarze() {
		return lekarze;
	}
	
	public String addLekarz() {

		lm.addLekarz(lekarz);

		return "pokazLekarzy";
	}

	public String deleteLekarz() {
		Lekarz l = lekarze.getRowData();
		lm.deleteLekarz(l);

		return "pokazLekarzy";
	}
	

}
