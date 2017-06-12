package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MysqlConnect {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://192.168.14.35?user=bibliothek&password=InfLb15.admin");

            statement = connect.createStatement();
           

         /*PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  kunden values (default, ?, ?, ?, ? , ?, ?)");
         
            preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestEmail");
            preparedStatement.setString(3, "TestWebpage");
            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStatement.setString(5, "TestSummary");
            preparedStatement.setString(6, "TestComment");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);*/


            // Remove again the insert comment
            //preparedStatement = connect
            //.prepareStatement("delete from feedback.comments where myuser= ? ; ");
            //preparedStatement.setString(1, "Test");
            //preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from mydb.tbl_kunde;");
            writeResultSet(resultSet);
            writeMetaData(resultSet);
            

		        } catch (Exception e) {
		            throw e;
		        } finally {
		            close();
		        }
		
		    }
    
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String idKunde = resultSet.getString("id_kunde");
            String name = resultSet.getString("name");
            String vorname = resultSet.getString("vorname");
            int gebJahr = resultSet.getInt("geburtsjahr");
            String strasse = resultSet.getString("strasse");
            int hnr = resultSet.getInt("nummer");
            String ort = resultSet.getString("fk_ort");
            System.out.println(idKunde);
            System.out.println(name);
            System.out.println(vorname);
            System.out.println(gebJahr);
            System.out.println(strasse);
            System.out.println(hnr);
            System.out.println(ort);
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            /* e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);*/
        }
    }

    // You need to close the resultSet
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
