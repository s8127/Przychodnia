package com.przychodnia.main;

public class Lekarz {
	private String imie;
	private String nazwisko;
	private String specjalizacja;
	
	public Lekarz(String imie, String nazwisko, String specjalizacja) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.specjalizacja=specjalizacja;
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

}
