package com.przychodnia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.przychodnia.main.Lekarz;
import com.przychodnia.main.Pacjent;

public class DBLekarz {
	private PreparedStatement insertStmt;
	private PreparedStatement selectStmt;
	private PreparedStatement selectImieStmt;
	private PreparedStatement selectPacjentStmt;
	private PreparedStatement deleteStmt;
	public DBLekarz(Connection connection) throws SQLException {
		insertStmt = connection.prepareStatement("INSERT INTO lekarze (imie,nazwisko,specjalizacja) VALUES (?,?,?)");
		selectStmt = connection.prepareStatement("SELECT * FROM lekarze");
		selectImieStmt=connection.prepareStatement("SELECT * FROM lekarze WHERE (imie) = (?) LIMIT 1");
		selectPacjentStmt = connection.prepareStatement("SELECT * FROM pacjenci WHERE (lekarz_id) =(?) ");
		deleteStmt=connection.prepareStatement("DELETE FROM lekarze WHERE (id) = (?)");
		
	}
	
	public void dodajLekarza(Lekarz lekarz) throws SQLException{
		insertStmt.setString(1, lekarz.getImie());
		insertStmt.setString(2, lekarz.getNazwisko());
		insertStmt.setString(3, lekarz.getSpecjalizacja());
		insertStmt.executeUpdate();
	}
	
	public List<Lekarz> znajdzWszystkichLekarzy() throws SQLException{
		List<Lekarz> lekarze = new ArrayList<Lekarz>();
		ResultSet rs = selectStmt.executeQuery();
		while(rs.next()){
			Lekarz l = new Lekarz(rs.getString("imie"), rs.getString("nazwisko"), rs.getString("specjalizacja"));
			l.setId(rs.getInt("id"));
			selectPacjentStmt.setInt(1, l.getId());
			ResultSet rss= selectPacjentStmt.executeQuery();
			while(rss.next()){
				
				Pacjent pacjent = new Pacjent(rss.getString("imie"), rs.getString("nazwisko"), rs.getInt("wiek"));
				pacjent.setLekarzId(l.getId());
				l.getListaPacjentow().add(pacjent);
			}
			
			lekarze.add(l);
			
		}
		return lekarze;
	}
	
	public Lekarz znajdzLekarzaPoImieniu(String imie) throws SQLException{
		selectImieStmt.setString(1, imie);
		selectImieStmt.executeQuery();
		ResultSet rs = selectImieStmt.executeQuery();
		if(rs.next()){
			Lekarz l = new Lekarz(rs.getString("imie"), rs.getString("nazwisko"), rs.getString("specjalizacja"));
			l.setId(rs.getInt("id"));
			selectPacjentStmt.setInt(1, l.getId());
			ResultSet rss= selectPacjentStmt.executeQuery();
			while(rss.next()){
				
				Pacjent pacjent = new Pacjent(rss.getString("imie"), rs.getString("nazwisko"), rs.getInt("wiek"));
				pacjent.setLekarzId(l.getId());
				l.getListaPacjentow().add(pacjent);
			}
			return l;
		}
		return null;
		
	}
	
	
	
	
	public void usunLekarza(Lekarz lekarz) throws SQLException{
		deleteStmt.setInt(1, lekarz.getId());
		deleteStmt.executeUpdate();
	}
	

}
