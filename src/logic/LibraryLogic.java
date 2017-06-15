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

	public boolean addKunde(Kunde k){
		
		return false;
	}

	
	public boolean addMedien(short altersfreigabe, String autor,  String genre, long ID, String ISBN, String standortCode, String titel){
		return false;
	}

	
	public boolean ausleihenRuckgabe(Medium m, Long kundeID){
		return false;
	}


	public boolean changeAdress(String street, int hnr, int plz, String ort, Long kundeID){
		return false;
	}

	
	public String searchKunde(Long kundeID){
		String ausgabe = "Kein Kunde gefunden!";
		try{
			Kunde k = dataAccess.getKundeById(kundeID);
			
			ausgabe =	k.getString();
		}catch (Exception e){}
		
		return ausgabe;
	}
	
			

	
	public Medium searchMedien(Long mediumID){
		return null;
	}

}