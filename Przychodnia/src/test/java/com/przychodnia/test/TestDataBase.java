package com.przychodnia.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.przychodnia.db.DBLekarz;
import com.przychodnia.db.DBManager;
import com.przychodnia.main.Lekarz;

public class TestDataBase {
	

	private static DBManager db;
	private static DBLekarz dbl;
	private static Lekarz l1;
	private static Lekarz l2;
	private static Lekarz l3;

	@BeforeClass
	public static void stworzBaze() throws SQLException{
		db=new DBManager();
		dbl = new DBLekarz(db.getConnection());
		
		l1 = new Lekarz("Jan", "Nowak", "kardiolog");
		l2 = new Lekarz("Tomasz", "Kowalski", "okulista");
		l3 = new Lekarz("Stefan", "Czarnecki", "neurolog");
		
		
	}
	
	@Test
	public void testDodajLekarza() throws SQLException{
		dbl.dodajLekarza(l1);
		dbl.dodajLekarza(l2);
		dbl.dodajLekarza(l3);
		
		assertEquals(3, dbl.znajdzWszystkichLekarzy().size());
		
	}
	
	

}
