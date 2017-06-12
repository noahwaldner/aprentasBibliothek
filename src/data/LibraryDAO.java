package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import dto.Kunde;
import dto.Medium;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class LibraryDAO {
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    

	public LibraryDAO(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        // Setup the connection with the DB
	        connect = DriverManager
	                .getConnection("jdbc:mysql://192.168.14.35?user=bibliothek&password=InfLb15.admin");

	        statement = connect.createStatement();
	        
			}catch (Exception e) {
	            throw e; 
	        } finally {
	            close();
	        }
			
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
	public Kunde getKundeById(Long kundenid) throws Exception{
		
		Kunde k = new Kunde();
		
		try{
			
		preparedStatement = connect.prepareStatement("select * from mydb.kunden where id_kunde= ? ; ");
        preparedStatement.setString(1, kundenid.toString());
        preparedStatement.executeUpdate();
		
		k.setname(resultSet.getString("name"));
		k.setvorname(resultSet.getString("vorname"));
		k.setgeburtsjahr(resultSet.getInt("geburtsjahr"));
		k.setort(resultSet.getString("ort"));
		k.setstrasse(resultSet.getString("strasse"));
		k.sethnr(resultSet.getInt("hnr"));
		k.setplz(resultSet.getInt("plz"));
		k.setid(resultSet.getInt("id_kunde"));
		
		
		
		}catch (Exception e) {
            throw e; 
        } finally {
            close();
        }
		
		return k;
		
		
	}

	/**
	 * 
	 * @param mediumid
	 */
	public Medium getMediumById(Long mediumid){
		return null;
	}

	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}