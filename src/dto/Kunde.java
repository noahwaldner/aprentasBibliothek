package dto;


/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class Kunde {

	private int geburtsjahr;
	private int hnr;
	private long id;
	private String name;
	private String ort;
	private int plz;
	private String strasse;
	private String vorname;

	public Kunde(){

	}

	public int getgeburtsjahr(){
		return geburtsjahr;
	}

	public int gethnr(){
		return hnr;
	}

	public long getid(){
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
	
	public String getString(){
		String s = "";
<<<<<<< HEAD
		s = k.getid() +"\n"+ k.getname() + k.getvorname()+"\n" + k.getstrasse() + k.gethnr()+"\n" + k.getplz() + k.getort() +"\n"+ k.getgeburtsjahr(); 
=======
		s = getid() + getname() + getvorname() + getgeburtsjahr() + getstrasse() + gethnr() + getplz() + getort(); 
>>>>>>> branch 'master' of https://github.com/noahwaldner/aprentasBibliothek.git
		return s;	
	}

}