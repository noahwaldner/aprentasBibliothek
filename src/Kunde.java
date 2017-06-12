

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2017 14:52:33
 */
public class Kunde {

	private int geburtsjahr;
	private int hnr;
	private int id;
	private String name;
	private String ort;
	private int plz;
	private String strasse;
	private String vorname;

	public Kunde(){

	}

	public void finalize() throws Throwable {

	}
	public int getgeburtsjahr(){
		return geburtsjahr;
	}

	public int gethnr(){
		return hnr;
	}

	public int getid(){
		return id;
	}

	public String getname(){
		return name;
	}

	public String getort(){
		return ort;
	}

	public int getplz(){
		return plz;
	}

	public String getstrasse(){
		return strasse;
	}

	public String getvorname(){
		return vorname;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setgeburtsjahr(int newVal){
		geburtsjahr = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethnr(int newVal){
		hnr = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setid(int newVal){
		id = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setname(String newVal){
		name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setort(String newVal){
		ort = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setplz(int newVal){
		plz = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstrasse(String newVal){
		strasse = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setvorname(String newVal){
		vorname = newVal;
	}
}//end Kunde