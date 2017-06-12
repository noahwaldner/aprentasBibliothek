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

	/**
	 * 
	 * @param k
	 */
	public boolean addKunde(Kunde k){
		return false;
	}

	/**
	 * 
	 * @param m
	 */
	public boolean addMedien(Medium m){
		return false;
	}

	/**
	 * 
	 * @param m
	 * @param kundeID
	 */
	public boolean ausleihenRuckgabe(Medium m, Long kundeID){
		return false;
	}

	/**
	 * 
	 * @param street
	 * @param hnr
	 * @param plz
	 * @param ort
	 * @param kundeID
	 */
	public boolean changeAdress(String street, int hnr, short plz, String ort, Long kundeID){
		return false;
	}

	/**
	 * 
	 * @param kundeID
	 */
	public Kunde searchKunde(Long kundeID){
		return null;
	}

	/**
	 * 
	 * @param mediumID
	 */
	public Medium searchMedien(Long mediumID){
		return null;
	}

}