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
 * Diese Klasse gewährt den Datenbankzugriff. Es werden die Informationen aus
 * Objekte von Kunde und Medium ausgelesen und in die Datenbank geschrieben,
 * Informationen aus der Datenbank in Objekte geschrieben oder Datebankeinträge
 * verändert.
 * 
 * @author Noah Waldner
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class LibraryDAO {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * Es wird eine Verbindung zur DFatenbank über jbdc aufgebaut.
	 */
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

		}

	}

	/**
	 * Es wird über den Eingabeparameter ein Objekt des Typs Kunde eingegeben
	 * welches ausgelesen wird. Es wird getestet ob schon ein Eintrag in tbl_ort
	 * mit dem angegebenen Ort und der angegebenen Postleitzahl besteht. Falls
	 * ja, wird die Id davon ausgelesen und zwischengespeichert. Falls nein,
	 * wird ein neuer Eintrag gemach und die Id zwischengespeichert. Es wird ein
	 * eintrag in tbl_kunde mit den angegebenen Werten gemacht. in die Spalte
	 * fk_ort wird die zwischengespeicherte id geschrieben.
	 * 
	 * @param newKunde
	 * @return success
	 *
	 */
	public boolean addKunde(Kunde newKunde) throws Exception {

		Boolean success = false;

		String name = newKunde.getname();
		String vorname = newKunde.getvorname();
		String strasse = newKunde.getstrasse();
		int hnr = newKunde.gethnr();
		String plz = newKunde.getplz();
		String ort = newKunde.getort();
		int geburtsjahr = newKunde.getgeburtsjahr();

		try {

			resultSet = statement
					.executeQuery("SELECT * from mydb.tbl_ort where NAME =\"" + ort + "\" and plz = " + plz + " ;");
			int ortid = 0;
			if (resultSet.next()) {
				ortid = resultSet.getInt("id_ort");
			} else {

				preparedStatement = connect.prepareStatement("insert INTO mydb.tbl_ort(name, plz) VALUES (?,?);");
				preparedStatement.setString(1, ort);
				preparedStatement.setString(2, plz);

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
	 * Es wird über den Eingabeparameter ein Objekt des Typs Medium eingegeben
	 * und ausgelesen. Die ausgelesenen Werte werden in die Tabelle tbl_medium
	 * auf der Datebank geschrieben.
	 * 
	 * @param newMedium
	 * @return success
	 */
	public boolean addMedium(Medium newMedium) throws Exception {

		Boolean success = false;

		Short altersfreigabe = newMedium.getaltersfreigabe();
		String autor = newMedium.getautor();
		String genre = newMedium.getgenre();
		String titel = newMedium.gettitel();
		String herausgeber = newMedium.getautor();
		String ean = newMedium.getISBN();
		String standort_code = newMedium.getstandortCode();

		try {

			preparedStatement = connect.prepareStatement("INSERT INTO mydb.tbl_medium"
					+ "(standort_code, titel, genre, altersfreigabe, herausgeber, ean) VALUES" + "(?,?,?,?,?,?)");

			preparedStatement.setString(1, standort_code);
			preparedStatement.setString(2, titel);
			preparedStatement.setString(3, genre);
			preparedStatement.setShort(4, altersfreigabe);
			preparedStatement.setString(5, herausgeber);
			preparedStatement.setString(6, ean);

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
	 * Über die eingabeparameter die Informationen über die neue Adresse
	 * eigegeben.
	 *
	 * Es wird getestet ob schon ein Eintrag in tbl_ort mit dem angegebenen Ort
	 * und der angegebenen Postleitzahl besteht. Falls ja, wird die Id davon
	 * ausgelesen und zwischengespeichert. Falls nein, wird ein neuer Eintrag
	 * gemach und die Id zwischengespeichert. Es wird die Zeile in tbl_kunde wo
	 * id_kunde = die eingegebene Kunden ID ist mit den eingegebenen Werten
	 * geupdatet. In die Spalte fk_ort wird der zwischengespeicherte Wert
	 * geschrieben
	 *
	 * @param newStrasse
	 * @param newHnr
	 * @param newPlz
	 * @param newOrt
	 * @param kundeID
	 * @return success
	 */
	public boolean changeAdress(String newStrasse, int newHnr, String newPlz, String newOrt, Long kundeID) {

		boolean success = false;
		try {

			resultSet = statement.executeQuery(
					"SELECT * from mydb.tbl_ort where NAME =\"" + newOrt + "\" and plz = " + newPlz + " ;");
			int ortid = 0;
			if (resultSet.next()) {
				ortid = resultSet.getInt("id_ort");
			} else {

				preparedStatement = connect.prepareStatement("insert INTO mydb.tbl_ort(name, plz) VALUES (?,?);");
				preparedStatement.setString(1, newOrt);
				preparedStatement.setString(2, newPlz);

				preparedStatement.executeUpdate();

				resultSet = statement.executeQuery(
						"SELECT id_ort from mydb.tbl_ort where NAME =\"" + newOrt + "\" and plz = " + newPlz + " ;");
				while (resultSet.next()) {
					ortid = resultSet.getInt("id_ort");
				}
			}

			preparedStatement = connect.prepareStatement(
					"UPDATE mydb.tbl_kunde SET strasse = ?, nummer = ?, fk_ort = " + ortid + " WHERE id_kunde = ?;");
			preparedStatement.setString(1, newStrasse);
			preparedStatement.setInt(2, newHnr);
			preparedStatement.setLong(3, kundeID);
			preparedStatement.executeUpdate();

			System.out.println("Adresse geaendert!");
			success = true;

		} catch (Exception e) {
			System.out.println("Kunde nicht gefunden");

		} finally {

			close();
			return success;
		}
	}

	/**
	 * Es ird ein Long wert eigegeben. Auf der view v_zeigeKunde auf der
	 * Datenbank wird nach einer Zeile gesucht in welcher id_kunde = die
	 * eigegebene Kunden ID ist. Es werden die Informationen aus dieser Zeile in
	 * ein Objekt des Typs Kunde gespeichert.
	 * 
	 * @param kundenid
	 * @return k
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
			System.out.println("Kunde nicht gefunden");
			throw e;

		} finally {
			close();
		}

		return k;

	}

	/**
	 * Es ird ein Long wert eigegeben. Auf der Tabelle tbl_medium auf der
	 * Datenbank wird nach einer Zeile gesucht in welcher id_medium = die
	 * eigegebene Medium ID ist. Es werden die Informationen aus dieser Zeile in
	 * ein Objekt des Typs Kunde gespeichert.
	 * 
	 * @param mediumid
	 *
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
			System.out.println("Medium nicht gefunden");
		} finally {
			close();
		}

		return m;

	}

	/**
	 * Es wird ein werd des Typs Long eingegeben und überprüft ob ein eintrag
	 * in der Tablelle tbl_ausleihe besteht, in welchem die Spalte fk_medium =
	 * die eingegebene Medien ID ist.
	 * 
	 * @param mediumId
	 * @return
	 */
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

	/**
	 * Es wird ein Long wert eigegeben. Es wird der Eintrag in der Tabelle
	 * tbl_ausleihe gelöscht in welchem fk_medium = die eigegebene Medien ID
	 * ist.
	 * 
	 * @param mediumId
	 */
	public void ruckgeben(Long mediumId) throws Exception {
		try {

			statement.executeUpdate("delete from mydb.tbl_ausleihe where fk_medium= " + mediumId + ";");

			System.out.println("Medium wurde zurueckgegeben");

		} catch (Exception e) {
			System.out.println("Medium nicht gefunden");
		} finally {
			close();
		}
	}

	/**
	 * Es werden zwei Long Werte eigegeben. Es wird ein Eintrag in der Tabelle
	 * tbl_ausleihe erstellt in welchem fk_kunde = dem eingegeben Wert KundeId
	 * und fk_kunde = dem eingegeben Wert MediumID ist. In die Spalte "adate"
	 * wird das aktuelle Datum geschrieben.
	 * 
	 * @param mediumId
	 * @param kundeId
	 */
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

			System.out.println("Kunde oder Medium nicht gefunden");
		} finally {
			close();
		}
	}

	/**
	 * Es wird die Datenbankverbindung geschlossen.
	 */
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
	
	/**
	 * Loescht den Eintrag in tbl_kunde wo die Spalte id_kunde = den eingegebenen Wert kundeID hat.
	 * @param kundeID
	 */
	public void deleteKunde(Long kundeID){
		try {

			statement.executeUpdate("delete from mydb.tbl_kunde where id_kunde= " + kundeID + ";");

			System.out.println("Kunde wurde geloescht");

		} catch (Exception e) {
			System.out.println("Kunde nicht gefunden");
		} finally {
			close();
		}
	}
	
	
	/**
	 * Loescht den Eintrag in tbl_medium wo id_medium = den eingegebenen Wert mediumID hat.
	 * @param kundeID
	 */
	public void deleteMedium(Long mediumID){
		try {

			statement.executeUpdate("delete from mydb.tbl_kunde where fk_medium= " + mediumID + ";");
			System.out.println("Medium wurde geloescht");

		} catch (Exception e) {
			System.out.println("Medium nicht gefunden");
		} finally {
			close();
		}
	}

}