package Management;

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2017 14:52:32
 */
public class Management {

	public Management(){

	}

	public void finalize() throws Throwable {

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
	public boolean ausleihen(Medium m, Long kundeID){
		return false;
	}

	/**
	 * 
	 * @param street
	 * @param hnr
	 * @param plz
	 * @param ort
	 */
	public boolean changeAdress(String street, int hnr, short plz, String ort){
		return false;
	}

	/**
	 * 
	 * @param m
	 */
	public boolean ruckgeben(Medium m){
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
}//end Management