package com.przychodnia.main;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "lekarz.all", query = "Select l from Lekarz l")
})
public class Lekarz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min=2, max =20)
	private String imie;
	@Size(min=2, max =20)
	private String nazwisko;
	@Size(min=2, max =20)
	private String specjalizacja;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pacjent> listaPacjentow;
	
	
	
	public Lekarz() {
	}


	public Lekarz(String imie, String nazwisko, String specjalizacja) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.specjalizacja=specjalizacja;
		this.listaPacjentow = new ArrayList<Pacjent>();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getSpecjalizacja() {
		return specjalizacja;
	}

	public void setSpecjalizacja(String specjalizacja) {
		this.specjalizacja = specjalizacja;
	}



	public List<Pacjent> getListaPacjentow() {
		return listaPacjentow;
	}



	public void setListaPacjentow(List<Pacjent> listaPacjentow) {
		this.listaPacjentow = listaPacjentow;
	}



}