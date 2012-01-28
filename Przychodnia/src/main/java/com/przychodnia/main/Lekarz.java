package com.przychodnia.main;

import java.util.List;

public class Lekarz {
	private int id;
	private String imie;
	private String nazwisko;
	private String specjalizacja;
	private List<Pacjent> listaPacjentow;
	
	
	public Lekarz(String imie, String nazwisko, String specjalizacja) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.specjalizacja=specjalizacja;
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
