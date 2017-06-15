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

	public LibraryLogic() throws Exception{
		dataAccess = new LibraryDAO();
	}



	public boolean addKunde(int geburtsjahr, int hnr, long id, String name, String ort, String plz, String strasse, String vorname) throws Exception {
		try{
			Kunde k = new Kunde();
			k.setgeburtsjahr(geburtsjahr);
			k.sethnr(hnr);
			k.setid(id);
			k.setname(name);
			k.setort(ort);
			k.setplz(plz);
			k.setstrasse(strasse);
			k.setvorname(vorname);
			Boolean success = dataAccess.addKunde(k);

			return (success);
		}catch (Exception e){

			return false;
		}

	}


	
	public boolean addMedien(short altersfreigabe, String autor,  String genre, int ID, String ISBN, String standortCode, String titel){
		Medium m = new Medium();
		m.setaltersfreigabe(altersfreigabe);
		m.setautor(autor);
		m.setgenre(genre);
		m.setID(ID);
		m.setISBN(ISBN);
		m.setstandortCode(standortCode);
		m.settitel(titel);
		
		return true;

	}

	
	public boolean ausleihenRuckgabe(Medium m, Long kundeID){
		return false;
	}


	public boolean changeAdress(String street, int hnr, String plz, String ort, Long kundeID){
		try {
			Kunde k = dataAccess.getKundeById(kundeID);
			k.setstrasse(street);
			k.sethnr(hnr);
			k.setplz(plz);
			k.setort(ort);
		} catch (Exception e) {
		}
		return true;
	}


	
	public String searchKunde(Long kundeID){
		String ausgabe = "Kein Kunde gefunden!";
		try{
			Kunde k = dataAccess.getKundeById(kundeID);
			
			ausgabe =	k.getString();
		}catch (Exception e){}
		
		return ausgabe;
	}
	
			

	
	public String searchMedien(Long mediumID){
		String ausgabe = "Kein Kunde gefunden!";
		try{
			Medium m = dataAccess.getMediumById(mediumID);
			
			ausgabe =	m.getString();
		}catch (Exception e){}
		
		return ausgabe;
		
	}


}