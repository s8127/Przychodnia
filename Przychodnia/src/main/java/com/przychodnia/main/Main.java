package com.przychodnia.main;

import java.sql.SQLException;

import com.przychodnia.db.DBLekarz;
import com.przychodnia.db.DBManager;
import com.przychodnia.db.DBPacjent;

public class Main {
	private static DBManager baza;
	private static DBLekarz dbl;
	private static DBPacjent dbp;
	private static Lekarz l1;
	private static Lekarz l2;
	private static Lekarz l3;
	private static Pacjent p1;
	private static Pacjent p2;
	private static Pacjent p3;
	private static Pacjent p4;

	public static void main(String[] args) throws SQLException {
		baza = new DBManager();
		dbl = new DBLekarz(baza.getConnection());
		dbp = new DBPacjent(baza.getConnection());

		l1 = new Lekarz("Jan", "Nowak", "kardiolog");
		l2 = new Lekarz("Tomasz", "Kowalski", "okulista");
		l3 = new Lekarz("Stefan", "Czarnecki", "neurolog");

		p1 = new Pacjent("Michal", "Michalski", 55);
		p2 = new Pacjent("Karol", "Karolski", 33);
		p3 = new Pacjent("Maciej", "Maciejski", 22);
		p4 = new Pacjent("Krzysztof", "Krzysztofski", 34);

		System.out.println("Dodawanie pacjentow");

		dbp.dodajPacjenta(p1);
		dbp.dodajPacjenta(p2);
		dbp.dodajPacjenta(p3);
		dbp.dodajPacjenta(p4);

		p1 = dbp.znajdzPacjentaPoImieniu(p1.getImie());
		p2 = dbp.znajdzPacjentaPoImieniu(p2.getImie());
		p3 = dbp.znajdzPacjentaPoImieniu(p3.getImie());
		p4 = dbp.znajdzPacjentaPoImieniu(p4.getImie());

		System.out.println("Dodawanie lekarzy");

		dbl.dodajLekarza(l1);
		dbl.dodajLekarza(l2);
		dbl.dodajLekarza(l3);

		l1 = dbl.znajdzLekarzaPoImieniu(l1.getImie());
		l2 = dbl.znajdzLekarzaPoImieniu(l2.getImie());
		l3 = dbl.znajdzLekarzaPoImieniu(l3.getImie());

		wyswietlBaze();

		System.out.println("Ustawianie lekarzy");

		dbp.ustawLekarza(p1, l1);
		dbp.ustawLekarza(p2, l1);
		dbp.ustawLekarza(p3, l2);
		dbp.ustawLekarza(p4, l3);

		wyswietlBaze();
		
		System.out.println("Zamiana pacjentow");
		
		dbp.ustawLekarza(p2, l2);
		dbp.ustawLekarza(p3, l3);
		dbp.ustawLekarza(p4, l3);
		
		wyswietlBaze();
	}

	private static void wyswietlBaze() throws SQLException {
		System.out.println();
		System.out.println("Dane w bazie:");
		System.out.println("Lekarze:");
		for (Lekarz l : dbl.znajdzWszystkichLekarzy()) {
			System.out.println("Lekarz: Imie: " + l.getImie() + ", Nazwisko: "
					+ l.getNazwisko() + ", Specjalizacja: "
					+ l.getSpecjalizacja());
			
			System.out.println("   Pacjenci tego lekarza: ");
			for (Pacjent p : l.getListaPacjentow()) {
				System.out.println("   Pacjent: Imie: " + p.getImie() + ", Nazwisko: "
						+ p.getNazwisko() + ", Wiek: " + p.getWiek());
			}
			System.out.println();
		}

		System.out.println();
	}
}
