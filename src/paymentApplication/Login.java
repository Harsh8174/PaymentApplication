package paymentApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
   private String upi_id;
   private long password;
   
   Scanner sc=new Scanner(System.in);

   void checker() throws Exception{
	   System.out.println("Enter Existing upi_id");
	   String upi_id= sc.next();
	   System.out.println("Enter password");
	   String password=sc.next();
	   String query="select * from user where upi_id=? and password=?";
	      PreparedStatement pst= DBCONNECTION.connection().prepareStatement(query);
          pst.setString(1, upi_id);
          pst.setString(2, password);
	      ResultSet rs=pst.executeQuery();
	      if(rs.next()) {
	    	  System.out.println("Login Successful");
	    	  User u=new User(rs.getString("user_name"), rs.getString("upi_id"),rs.getDouble("balance"),rs.getString("user_pin"), rs.getString("password"));
	    	  MoneyTransaction obj=new MoneyTransaction();
	    	  obj.Transaction(u);
	      }
	      else {
	    	  System.out.println("Login Unsuccessfull");
            System.out.println("Want to create Account");
               String choice=sc.next();
               if(choice.equalsIgnoreCase("yes")) {
            	   CreateAccount RegisterUser=new CreateAccount();
    	    	   RegisterUser.createaccount();
               }
               else {
            	   System.out.println("Thank you");
               }
	      }
   }
}
