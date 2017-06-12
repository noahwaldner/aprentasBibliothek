package UserInterface;

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2017 14:52:32
 */
public class Interface {

	public Interface(){

	}

	public static void main(String[] args){
		System.out.print("Hello World!");
	};

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
	 * @param mediumId
	 * @param kundeId
	 */
	public boolean ausleihenById(Long mediumId, Long kundeId){
		return false;
	}

	/**
	 * 
	 * @param street
	 * @param hnr
	 * @param plz
	 * @param ort
	 */
	public void changeAdress(String street, int hnr, short plz, String ort){

	}



	/**
	 * 
	 * @param kundenId
	 */
	public Kunde showKundeById(Long kundenId){
		return null;
	}

	/**
	 * 
	 * @param mediumid
	 */
	public boolean showMediumById(Long mediumid){
		return false;
	}
}//end Management.UserInterface.Interface