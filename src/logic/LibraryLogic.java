package logic;

import data.LibraryDAO;
import dto.Kunde;
import dto.Medium;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class LibraryLogic {

	private LibraryDAO dataAccess;

	public LibraryLogic() throws Exception {
		dataAccess = new LibraryDAO();
	}

	/**
	 * Es wird aus den Eingabeparametern ein Objekt des Typs Kunde zusammengebaut welches an die Methode addKunde im LibraryDAO weitergegeben wird.
	 *
	 * @param geburtsjahr
	 * @param hnr
	 * @param name
	 * @param ort
	 * @param plz
	 * @param strasse
	 * @param vorname
	 * @return success

	 */
	public boolean addKunde(int geburtsjahr, int hnr, String name, String ort, String plz, String strasse,
			String vorname) throws Exception {
		try {
			Kunde k = new Kunde();
			k.setgeburtsjahr(geburtsjahr);
			k.sethnr(hnr);
			k.setname(name);
			k.setort(ort);
			k.setplz(plz);
			k.setstrasse(strasse);
			k.setvorname(vorname);
			Boolean success = dataAccess.addKunde(k);

			return (success);
		} catch (Exception e) {

			return false;
		}

	}

	/**
	 * Es wird aus den Eingabeparametern ein Objekt des Typs Medium zusammengebaut welches an die Methode addMedium im LibraryDAO weitergegeben wird.
	 *
	 * @param altersfreigabe
	 * @param autor
	 * @param genre
	 * @param ISBN
	 * @param standortCode
	 * @param titel
	 * @return
	 */
	public boolean addMedien(short altersfreigabe, String autor, String genre, String ISBN, String standortCode,
			String titel) {

		try {
			Medium m = new Medium();
			m.setaltersfreigabe(altersfreigabe);
			m.setautor(autor);
			m.setgenre(genre);
			m.setISBN(ISBN);
			m.setstandortCode(standortCode);
			m.settitel(titel);

			Boolean success = dataAccess.addMedium(m);

			return (success);
		} catch (Exception e) {

			return false;
		}

	}

	/**
	 * Es wird die eigegebene MedienID an die Methode getAusgeliehen() im LibraryDAO gegeben um zu überprüfen ob das Medium ausgeliehen ist.
	 * Falls ausgeliehen: Eingegebe Medium ID wird an die Methode ruckgeben() im LibraryDAO gegeben.
	 * Falls nicht ausgeliehen: Eingegebe Medium ID und Kunde ID wird an die Methode ausleihen() im LibraryDAO gegeben.
	 * @param mediumId
	 * @param kundeId
	 */
	public boolean ausleihenRuckgabe(Long mediumId, Long kundeId) throws Exception {
		boolean isAusgeliehen = dataAccess.getAusgeliehen(mediumId);
		if (isAusgeliehen) {
			dataAccess.ruckgeben(mediumId);
		} else {
			dataAccess.ausleihen(mediumId, kundeId);
		};
		return false;
	}

	/**
	 * Die eingegebenen Werte werden an die Methode changeAdress im LibraryDAO gegeben.
	 * @param street
	 * @param hnr
	 * @param plz
	 * @param ort
	 * @param kundeID
	 */
	public boolean changeAdress(String street, int hnr, String plz, String ort, Long kundeID) {

		dataAccess.changeAdress(street, hnr, plz, ort, kundeID);
		return true;
	}

	/**
	 * Standartmässig wird der rueckgabewert in der Variabel "ausgabe" auf "Kein Kunde gefunden!" gesetzt.
	 * Es wird der Eingegebene Wert an die methode getKundeById gegeben und der rückgabewert (Objekt vom Typ Kunde) zwischengespeichert.
	 * Auf dem zwischengespeicherten Objekt wird die Methode getString() aufgerufen und der Rückgabewert in die variabel "ausgabe" gespeichert.
	 *
	 * @param kundeID
	 * @return String ausgabe
	 */
	public String searchKunde(Long kundeID) {
		String ausgabe = "Kein Kunde gefunden!";
		try {
			Kunde k = dataAccess.getKundeById(kundeID);

			ausgabe = k.getString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ausgabe;
	}

	/**
	 * Standartmaessig wird der rückgabewert in der Variabel "ausgabe" auf "Kein Medium gefunden!" gesetzt.
	 * Es wird der Eingegebene Wert an die methode getMediumById gegeben und der Rückgabewert (Objekt vom Typ Medium) zwischengespeichert.
	 * Auf dem zwischengespeicherten Objekt wird die Methode getString() aufgerufen und der Rückgabewert in die variabel "ausgabe" gespeichert.
	 *
	 * @param mediumID
	 * @return String ausgabe
	 */
	public String searchMedien(Long mediumID) {
		String ausgabe = "Kein medium gefunden!";
		try {
			Medium m = dataAccess.getMediumById(mediumID);

			ausgabe = m.getString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ausgabe;

	}
	
	/**
	 * gibt eingegebenen Wert kundenID an Methode deleteKunde() im LibraryDAO weiter
	 * @param kundenId
	 */
	public void deleteKunde(long kundenId){
		dataAccess.deleteKunde(kundenId);
	}
	
	/**
	 * gibt eingegebenen Wert mediumID an Methode deleteMedium() im LibraryDAO weiter
	 * @param kundenId
	 */
	public void deleteMedium(long mediumId){
		dataAccess.deleteKunde(mediumId);
	}

}