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

	public LibraryLogic(){

	}


	public boolean addKunde(int geburtsjahr, int hnr, long id, String name, String ort, int plz, String strasse, String vorname){
		return false;
	}

	
	public boolean addMedien(short altersfreigabe, String autor,  String genre, int ID, String ISBN, String standortCode, String titel){
		return false;
	}

	
	public boolean ausleihenRuckgabe(Medium m, Long kundeID){
		return false;
	}


	public boolean changeAdress(String street, int hnr, short plz, String ort, Long kundeID){
		return false;
	}


	public Kunde searchKunde(Long kundeID){
		return null;
	}

	
	public Medium searchMedien(Long mediumID){
		return null;
	}

}