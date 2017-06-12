package data;


import dto.Kunde;
import dto.Medium;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class LibraryDAO {

	public LibraryDAO(){

	}

	/**
	 * 
	 * @param newKunde
	 */
	public boolean addKunde(Kunde newKunde){
		return false;
	}

	/**
	 * 
	 * @param newMedium
	 */
	public boolean addMedium(Medium newMedium){
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
	 * @param kundenid
	 */
	public Kunde getKundeById(Long kundenid){
		return null;
	}

	/**
	 * 
	 * @param mediumid
	 */
	public Medium getMediumById(Long mediumid){
		return null;
	}

}