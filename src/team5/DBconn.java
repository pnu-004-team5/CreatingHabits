package team5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	public static void main(String[] args) throws SQLException {
		   Connection con = getConnection();
		   con.close();
	   }
	   
	   public static Connection getConnection() throws SQLException {
		   Connection con = null; //initialize variable
		   try {
		       con = DriverManager.getConnection("jdbc:postgresql://master.ckkvmjwwf3pk.us-east-2.rds.amazonaws.com/postgres","kjh95044", "rlawlghd1!");
		       System.out.println("Successfully connected.");
		   } catch (SQLException e) {
		       System.out.println("Problem with your connection");
		   }
		   
		   
		   return con;
	   }
}