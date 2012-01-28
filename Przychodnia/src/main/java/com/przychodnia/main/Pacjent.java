package com.przychodnia.main;

public class Pacjent {
	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private int lekarzId;

	public Pacjent(String imie, String nazwisko, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
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

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getLekarzId() {
		return lekarzId;
	}

	public void setLekarzId(int lekarzId) {
		this.lekarzId = lekarzId;
	}

}
