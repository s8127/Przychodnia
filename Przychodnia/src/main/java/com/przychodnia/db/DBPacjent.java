package com.przychodnia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.przychodnia.main.Lekarz;
import com.przychodnia.main.Pacjent;

public class DBPacjent {

	private PreparedStatement insertStmt;
	private PreparedStatement selectStmt;
	private PreparedStatement selectImieStmt;
	private PreparedStatement updateWiekStmt;
	private PreparedStatement updateLekarzStmt;
	private PreparedStatement deleteImieStmt;
	private PreparedStatement deleteStmt;

	public DBPacjent(Connection connection) throws SQLException {

		insertStmt = connection
				.prepareStatement("INSERT INTO pacjenci (imie,nazwisko,wiek) VALUES (?,?,?)");

		selectStmt = connection.prepareStatement("SELECT * FROM pacjenci");

		selectImieStmt = connection
				.prepareStatement("SELECT * FROM pacjenci WHERE (imie) = (?) LIMIT 1");

		updateWiekStmt = connection
				.prepareStatement("UPDATE pacjenci SET wiek=(?)  WHERE (imie) = (?)");

		updateLekarzStmt = connection
				.prepareStatement("UPDATE pacjenci SET lekarz_id=(?) WHERE (imie) =(?)");

		deleteImieStmt = connection
				.prepareStatement("DELETE FROM pacjenci WHERE imie = (?)");

		deleteStmt = connection
				.prepareStatement("DELETE FROM pacjenci ");
	}
	
	public void dodajPacjenta(Pacjent pacjent) throws SQLException{
		insertStmt.setString(1, pacjent.getImie());
		insertStmt.setString(2, pacjent.getNazwisko());
		insertStmt.setInt(3, pacjent.getWiek());
		insertStmt.executeUpdate();
	}
	
	public List<Pacjent> znajdzWszystkichPacjentow() throws SQLException{
		List<Pacjent> pacjenci = new ArrayList<Pacjent>();
		ResultSet rs = selectStmt.executeQuery();
		while(rs.next()){
			Pacjent p = new Pacjent(rs.getString("imie"), rs.getString("nazwisko"), rs.getInt("wiek"));
			p.setId(rs.getInt("id"));
			p.setLekarzId(rs.getInt("lekarz_id"));
			
			
			pacjenci.add(p);
			
		}
		return pacjenci;
	}
	
	public Pacjent znajdzPacjentaPoImieniu(String imie) throws SQLException{
		selectImieStmt.setString(1, imie);
		selectImieStmt.executeQuery();
		ResultSet rs = selectImieStmt.executeQuery();
		if(rs.next()){
			Pacjent p = new Pacjent(rs.getString("imie"), rs.getString("nazwisko"), rs.getInt("wiek"));
			p.setId(rs.getInt("id"));
			p.setLekarzId(rs.getInt("lekarz_id"));
			return p;
		}
		return null;
		
	}
	
	
	public void zmienWiekPacjenta(Pacjent pacjent, int wiek) throws SQLException{
		updateWiekStmt.setInt(1, wiek);
		updateWiekStmt.setString(2, pacjent.getImie());
		updateWiekStmt.executeUpdate();
	}
	
	public void zmienLekarza(Pacjent pacjent, Lekarz lekarz) throws SQLException{
		
		updateLekarzStmt.setInt(1, lekarz.getId());
		updateLekarzStmt.setString(2, pacjent.getImie());
		updateLekarzStmt.executeUpdate();
	}
	
	
	
	public void usunPacjentaPoImieniu(String imie) throws SQLException{
		deleteImieStmt.setString(1, imie);
		deleteImieStmt.executeUpdate();
	}
	
	public void usunPacjentow() throws SQLException{
		deleteStmt.executeUpdate();
	}
	

}