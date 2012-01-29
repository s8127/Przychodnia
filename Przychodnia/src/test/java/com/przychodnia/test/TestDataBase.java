package com.przychodnia.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.przychodnia.db.DBLekarz;
import com.przychodnia.db.DBManager;
import com.przychodnia.db.DBPacjent;
import com.przychodnia.main.Lekarz;
import com.przychodnia.main.Pacjent;

public class TestDataBase {

	private static DBManager db;
	private static DBLekarz dbl;
	private static DBPacjent dbp;
	private static Lekarz l1;
	private static Lekarz l2;
	private static Lekarz l3;
	private static Pacjent p1;
	private static Pacjent p2;
	private static Pacjent p3;
	private static Pacjent p4;

	@BeforeClass
	public static void stworzBaze() throws SQLException {
		db = new DBManager();
		dbl = new DBLekarz(db.getConnection());
		dbp = new DBPacjent(db.getConnection());

		l1 = new Lekarz("Jan", "Nowak", "kardiolog");
		l2 = new Lekarz("Tomasz", "Kowalski", "okulista");
		l3 = new Lekarz("Stefan", "Czarnecki", "neurolog");

		p1 = new Pacjent("Michal", "Michalski", 55);
		p2 = new Pacjent("Karol", "Karolski", 33);
		p3 = new Pacjent("Maciej", "Maciejski", 22);
		p4 = new Pacjent("Krzysztof", "Krzysztofski", 34);
	}

	@Test
	public void testDodajLekarza() throws SQLException {
		dbl.dodajLekarza(l1);
		dbl.dodajLekarza(l2);
		dbl.dodajLekarza(l3);

		assertEquals(3, dbl.znajdzWszystkichLekarzy().size());

	}

	@Test
	public void testDodajPacjenta() throws SQLException {
		dbp.dodajPacjenta(p1);
		dbp.dodajPacjenta(p2);
		dbp.dodajPacjenta(p3);
		dbp.dodajPacjenta(p4);
		assertEquals(4, dbp.znajdzWszystkichPacjentow().size());

	}

	@Test
	public void testZnajdzLekarza() throws SQLException {
		String imie = "Jan";
		assertSame(imie, dbl.znajdzLekarzaPoImieniu(imie).getImie());
	}

	@Test
	public void testZnajdzPacjenta() throws SQLException {
		String imie = "Karol";
		assertSame(imie, dbp.znajdzPacjentaPoImieniu(imie).getImie());
	}
	
	@Test
	public void testZmienSpecjalizacja() throws SQLException {
		String nowaSpecjalizacja = "Diabetolog";
		dbl.zmienSpecjalizacjeLekarza(l1, nowaSpecjalizacja);
		assertTrue(nowaSpecjalizacja == dbl.znajdzLekarzaPoImieniu(l1.getImie()).getSpecjalizacja());
	}

	@Test
	public void testZmienWiek() throws SQLException {
		int nowyWiek = 66;
		dbp.zmienWiekPacjenta(p1, nowyWiek);
		assertTrue(nowyWiek == dbp.znajdzPacjentaPoImieniu(p1.getImie()).getWiek());
	}
	
	@Test
	public void testUstawLekarza() throws SQLException{
		dbp.ustawLekarza(p2, l1);
	}
	

	@Test
	public void testUsunPacjenta() throws SQLException{
		dbp.usunPacjentaPoImieniu(p4.getImie());
		assertNull(dbp.znajdzPacjentaPoImieniu(p4.getImie()));
	}
	@Test
	public void testUsunPacjentow() throws SQLException{
		dbp.usunPacjentow();
		assertEquals(0,dbp.znajdzWszystkichPacjentow().size());
	}
	
	@Test
	public void testUsunLekarza() throws SQLException{
		dbl.usunLekarza(l3);
		assertNull(dbl.znajdzLekarzaPoImieniu(l3.getImie()));
	}
	

}
