package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.Kunde;
import dto.Medium;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class LibraryDAO {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public LibraryDAO() throws Exception {

		try {
			System.out.println("Connecting to Database...");
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://192.168.14.35?user=bibliothek&password=InfLb15.admin");

			statement = connect.createStatement();

		} catch (Exception e) {
			throw e;
		} finally {
			// close();
		}

	}

	/**
	 * 
	 * @param newKunde
	 */
	public boolean addKunde(Kunde newKunde) throws Exception {

		System.out.println("start of routine addKunde()...");

		Boolean success = false;

		String name = newKunde.getname();
		String vorname = newKunde.getvorname();
		String strasse = newKunde.getstrasse();
		int hnr = newKunde.gethnr();
		String plz = newKunde.getplz();
		String ort = newKunde.getort();
		int geburtsjahr = newKunde.getgeburtsjahr();

		System.out.println("trying to add...");

		try {
			
			resultSet = statement.executeQuery(
					"SELECT * from mydb.tbl_ort where NAME =\"" + ort + "\" and plz = " + plz + " ;");
			int ortid = 0;
			if (resultSet.next()) {
				ortid = resultSet.getInt("id_ort");
			}else{
				
				preparedStatement = connect.prepareStatement("insert INTO mydb.tbl_ort(name, plz) VALUES (?,?);");
				preparedStatement.setString(1, ort);
				preparedStatement.setString(2, plz);
				System.out.println("vor dem Execute...");
				preparedStatement.executeUpdate();

				resultSet = statement.executeQuery(
						"SELECT id_ort from mydb.tbl_ort where NAME =\"" + ort + "\" and plz = " + plz + " ;");
				while (resultSet.next()) {
					ortid = resultSet.getInt("id_ort");
				}
			}
			

			

			preparedStatement = connect.prepareStatement(
					"insert INTO mydb.tbl_kunde(name, vorname, geburtsjahr, strasse, nummer,fk_ort) VALUES (?,?,?,?,?,?);");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, vorname);
			preparedStatement.setInt(3, geburtsjahr);
			preparedStatement.setString(4, strasse);
			preparedStatement.setInt(5, hnr);
			preparedStatement.setInt(6, ortid);

			preparedStatement.executeUpdate();

			System.out.println("Kunde hinzugefügt");
			success = true;
		} catch (Exception e) {
			System.out.println("Fehler");
			System.out.println(e.getMessage());
			success = false;
		} finally {
			close();
		}

		return success;

	}

	/**
	 * 
	 * @param newMedium
	 */
	public boolean addMedium(Medium newMedium) throws Exception {
		System.out.println("Checkpoint 1 DAO");

		Boolean success = false;

		Short altersfreigabe = newMedium.getaltersfreigabe();
		String autor = newMedium.getautor();
		String genre = newMedium.getgenre();
		String titel = newMedium.gettitel();
		String herausgeber = newMedium.getautor();
		String ean = newMedium.getISBN();
		String standort_code = newMedium.getstandortCode();

		System.out.println("Checkpoint 2 DAO" + titel);
		try {

			preparedStatement = connect.prepareStatement("INSERT INTO mydb.tbl_medium"
					+ "(standort_code, titel, genre, altersfreigabe, herausgeber, ean) VALUES" + "(?,?,?,?,?,?)");

			preparedStatement.setString(1, standort_code);
			preparedStatement.setString(2, titel);
			preparedStatement.setString(3, genre);
			preparedStatement.setShort(4, altersfreigabe);
			preparedStatement.setString(5, herausgeber);
			preparedStatement.setString(6, ean);
			System.out.println("Execute!");
			preparedStatement.executeUpdate();
			System.out.println("added");
			success = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;

		} finally {
			close();
		}

		return success;
	}

	/**
	 * 
	 * @param street
	 * @param hnr
	 * @param plz
	 * @param ort
	 * @param kundeID
	 */
	public boolean changeAdress(String newStrasse, int newHnr, String newPlz, String newOrt, Long kundeID) {
		try {

			preparedStatement = connect
					.prepareStatement("UPDATE mydb.tbl_kunde SET strasse = ?, nummer = ? WHERE id_kunde = ?;");
			preparedStatement.setString(1, newStrasse);
			preparedStatement.setInt(2, newHnr);
			preparedStatement.setLong(3, kundeID);
			preparedStatement.executeUpdate();

			resultSet = statement.executeQuery("SELECT fk_ort from mydb.tbl_kunde where id_kunde = " + kundeID + ";");

			int ortid = 0;
			while (resultSet.next()) {
				ortid = resultSet.getInt("fk_ort");
			}

			preparedStatement = connect.prepareStatement("Update mydb.tbl_ort SET name=?, plz=? where id_ort = ?;");
			preparedStatement.setString(1, newOrt);
			preparedStatement.setString(2, newPlz);
			preparedStatement.setLong(3, ortid);
			
			preparedStatement.executeUpdate();
			System.out.println("Adresse geaendert!");
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		} finally {
			close();
		}
	}

	/**
	 * 
	 * @param kundenid
	 */
	public Kunde getKundeById(Long kundenid) throws Exception {

		Kunde k = new Kunde();

		try {

			ResultSet resultSet = statement
					.executeQuery("select * from mydb.v_zeigeKunde where KundenId=" + kundenid + " ; ");

			if (resultSet.next()) {

				k.setname(resultSet.getString("name"));
				k.setvorname(resultSet.getString("vorname"));
				k.setgeburtsjahr(resultSet.getInt("geburtsjahr"));
				k.setort(resultSet.getString("ort"));
				k.setstrasse(resultSet.getString("strasse"));
				k.sethnr(resultSet.getInt("Hausnummer"));
				k.setplz(resultSet.getString("plz"));
				k.setid(resultSet.getInt("KundenId"));

			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			throw e;

		} finally {
			close();
		}

		return k;

	}

	/**
	 * 
	 * @param mediumid
	 */
	public Medium getMediumById(Long mediumid) throws Exception {

		Medium m = new Medium();

		try {

			ResultSet resultSet = statement
					.executeQuery("select * from mydb.tbl_medium where id_medium= " + mediumid + ";");

			if (resultSet.next()) {
				m.setID(resultSet.getInt("id_medium"));
				m.setaltersfreigabe(resultSet.getShort("altersfreigabe"));
				m.setautor(resultSet.getString("herausgeber"));
				m.setgenre(resultSet.getString("genre"));
				m.setISBN(resultSet.getString("ean"));
				m.setstandortCode(resultSet.getString("standort_code"));
				m.settitel(resultSet.getString("titel"));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

		return m;

	}

	public boolean getAusgeliehen(Long mediumId) throws Exception {
		try {

			ResultSet resultSet = statement
					.executeQuery("select * from mydb.tbl_ausleihe where fk_medium= " + mediumId + ";");

			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw e;
		} finally {

		}

	}

	public void ruckgeben(Long mediumId) throws Exception {
		try {

			statement.executeUpdate("delete from mydb.tbl_ausleihe where fk_medium= " + mediumId + ";");

			System.out.println("Medium wurde zur�ckgegeben");

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public void ausleihen(Long mediumId, Long kundeId) throws Exception {
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

		try {

			preparedStatement = connect
					.prepareStatement("INSERT INTO mydb.tbl_ausleihe (fk_medium, fk_kunde, adatum) VALUES (?,?,?);");
			preparedStatement.setLong(1, mediumId);
			preparedStatement.setLong(2, kundeId);
			preparedStatement.setString(3, date);
			preparedStatement.executeUpdate();

			System.out.println("Medium wurde ausgeliehen");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}