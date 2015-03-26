package ch.grademasters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Fach;
import ch.grademasters.model.Pruefung;
import ch.grademasters.model.Zeugnis;

public class ZeugnisJDBCDao extends Database implements ZeugnisDao {
	private Connection con = null;

	public ArrayList<?> getZeugnis(int klassen_ID) throws SQLException {
		ArrayList<Zeugnis> zeugnisse = new ArrayList<Zeugnis>();
		ArrayList<Zeugnis> zeugnisKlassen = new ArrayList<Zeugnis>();
		
	
		String sql = "Select * from FACH WHERE Klasse_ID = ?;";
		con = getCon();
		ps = con.prepareStatement(sql);
		ps.setInt(1, klassen_ID);
		rs = ps.executeQuery();

		String sql3 = "Select Klasse, Schule, Semester From Klasse WHERE ID_Klasse = ?;";
		
		Zeugnis zeugnis = new Zeugnis();
		Fach fach;
		Pruefung pruefung;
		while (rs.next()) {
			fach = new Fach(rs.getString("Fach"));
			int fach_ID = rs.getInt("ID_Fach");
			zeugnis.addFach(fach);

			String sql2 = "Select * from PRUEFUNG WHERE FACH_ID = ?;";
			ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, fach_ID);
			rs2 = ps2.executeQuery();

			while (rs2.next()) {
				pruefung = new Pruefung(null, rs2.getFloat("Note"),
						rs2.getFloat("Gewichtung"));
				fach.addPruefung(pruefung);
			}
			zeugnisse.add(zeugnis);
		}
		closeCon();
		return zeugnisse;
	}

	// public String toString(){
	//
	// }

}
