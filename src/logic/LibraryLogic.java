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

	public boolean ausleihenRuckgabe(Long mediumId, Long kundeId) throws Exception {
		boolean isAusgeliehen = dataAccess.getAusgeliehen(mediumId);
		if (isAusgeliehen) {
			dataAccess.ruckgeben(mediumId);
		} else {
			dataAccess.ausleihen(mediumId, kundeId);
		}
		;
		return false;
	}

	public boolean changeAdress(String street, int hnr, String plz, String ort, Long kundeID) {

		dataAccess.changeAdress(street, hnr, plz, ort, kundeID);
		return true;
	}

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

	public String searchMedien(Long mediumID) {
		String ausgabe = "Kein Kunde gefunden!";
		try {
			Medium m = dataAccess.getMediumById(mediumID);

			ausgabe = m.getString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ausgabe;

	}

}