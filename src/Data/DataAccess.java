package Data;

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2017 14:52:33
 */
public class DataAccess {

	public DataAccess(){

	}

	public void finalize() throws Throwable {

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
	 */
	public boolean changeAdress(String street, int hnr, short plz, String ort){
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
}//end Data.DataAccess