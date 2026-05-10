package paymentApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCONNECTION {
	static void loaddriver() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  
	  }
	static Connection connection() throws Exception{
		    String url="jdbc:mysql://localhost:3306/upi_user";
		    String user_name="root";
		    String user_password="Pitambra@8174";
		   Connection conn=DriverManager.getConnection(url,user_name,user_password);
		   return conn;
	}
      
}
