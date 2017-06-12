

/**
 * @author aprentas
 * @version 1.0
 * @created 09-Jun-2017 14:52:34
 */
public class Medium {

	private short altersfreigabe;
	private String autor;
	private String genre;
	private int ID;
	private String ISBN;
	private int standortCode;
	private String titel;

	public Medium(){

	}

	public void finalize() throws Throwable {

	}
	public short getaltersfreigabe(){
		return altersfreigabe;
	}

	public String getautor(){
		return autor;
	}

	public String getgenre(){
		return genre;
	}

	public int getID(){
		return ID;
	}

	public String getISBN(){
		return ISBN;
	}

	public int getstandortCode(){
		return standortCode;
	}

	public String gettitel(){
		return titel;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setaltersfreigabe(short newVal){
		altersfreigabe = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setautor(String newVal){
		autor = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setgenre(String newVal){
		genre = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(int newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setISBN(String newVal){
		ISBN = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstandortCode(int newVal){
		standortCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settitel(String newVal){
		titel = newVal;
	}
}//end Medium