package javaExam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) throws SQLException {
		// class.forname 으로 jdb드라이버를로딩해야 함
		 Connection connection = null;
 	     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tododb", "kgw", "kgw");
 	     System.out.println("abc".equals(null));
 	     if("abc".equals(null)) {
 	    	 	System.out.println("wefwef");
 	     }
 	     if(connection != null){
 		        System.out.println("success");
 		        connection.close();
 	     }else
 		      System.out.println("fail");	
	}
}
