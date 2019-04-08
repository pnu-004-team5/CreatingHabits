

import java.sql.*;

public class test {
	   public static void main(String[] args) throws SQLException {
		   Connection con = null; //initialize variable
		   try {
		       con = DriverManager.getConnection("jdbc:postgresql://master.ckkvmjwwf3pk.us-east-2.rds.amazonaws.com/postgres","kjh95044", "rlawlghd1!");
		       System.out.println("Successfully connected.");
		   } catch (SQLException e) {
		       System.out.println("Problem with your connection");
		   }
	   }
}