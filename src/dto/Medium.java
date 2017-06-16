package dto;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 * 
 * In dieser Klasse sind die Getter-Setter des Medium-Objekts.
 * 
 */
public class Medium {
	private long ID;
	private short altersfreigabe;
	private String autor;
	private String genre;
	private String ISBN;
	private String standortCode;
	private String titel;

	public Medium() {

	}

	public short getaltersfreigabe() {
		return altersfreigabe;
	}

	public String getautor() {
		return autor;
	}

	public String getgenre() {
		return genre;
	}

	public long getID() {
		return ID;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getstandortCode() {
		return standortCode;
	}

	public String gettitel() {
		return titel;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setaltersfreigabe(short newVal) {
		altersfreigabe = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setautor(String newVal) {
		autor = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setgenre(String newVal) {
		genre = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(int newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setISBN(String newVal) {
		ISBN = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setstandortCode(String newVal) {
		standortCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settitel(String newVal) {
		titel = newVal;
	}

	public String getString() {
		String s = "";
		s = "ID: " + getID() + "\n" + gettitel() + "\n" + getautor() + "\n" + getgenre() + "\n" + getaltersfreigabe()
				+ "\n" + getstandortCode() + "\n" + getISBN();
		return s;
	}

}