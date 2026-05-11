package paymentApplication;

import java.sql.PreparedStatement;
import java.util.Scanner;

import TransactionHistory.Transactionhistory;
import paymentApplication.*;
import TransactionHistory.Transactionhistory;
public class CreateAccount {
	Scanner sc=new Scanner(System.in);
	Transactionhistory obj=new Transactionhistory();
	User createaccount() {
		  System.out.println("Enter user name");        	
          String name=sc.next();
     	 sc.next();
          System.out.println("Enter upi_id");
     	 String upi_id=sc.next();
     	 System.out.println("Enter Upi four digit pin");
     	 String pin=sc.next();
     	 pin_validation(pin);
     	 System.out.println("Enter password");
     	 String password=sc.next();
          password_validation(password);    	 
     	 System.out.println("Want to create premium account");
     	 System.out.println("Yes");
     	 System.out.println("No");
     	 
     	 String premium=sc.next();
        User u= premiumaccountcreation(premium, name, upi_id,pin,password);
     	return u;
	}
	void pin_validation(String pin) {
		if(pin.length()!=4) {
    		 System.out.println("Reenter pin must be equal to 4 digit");
    		 pin=sc.next();
    		 pin_validation(pin);
    	 }
	}
	void password_validation(String password) {
		if(password.length()!=8) {
    		 System.out.println("Renter password : Must less than 8digit");
    		 password=sc.next();
    		 password_validation(password);
    	 }
	}
	User premiumaccountcreation(String premium,String name,String upi_id,String pin,String password) {
		  if(premium.trim().equalsIgnoreCase("yes")){
			 System.out.println("Enter minimum balance you want to keep inside wallet");
			 double wallbal=sc.nextDouble();
			 if(wallbal>500) {
				  User u=new User(name, upi_id, wallbal, pin, password);
				  return u;
			 }
			 else {
				 System.out.println("Minimum balance to kept is 500");
				 premiumaccountcreation(premium, name,upi_id,pin,password);
			 }
		  }
		  else {
			    User u=new User(name,upi_id,pin,password);	    
			    return u;
		  }
		  
		  return null;
	  }
	void account_database_Storage() throws Exception{
		User u=createaccount();
	   //for user table
		String query="insert into user (upi_id,user_name,user_pin,password,balance) values(?,?,?,?,?)";
		 PreparedStatement pst= DBCONNECTION.connection().prepareStatement(query);
	     pst.setString(1, u.getUpi_id());
	     pst.setString(2, u.getName());
	     pst.setString(3, u.getUpi_pin());
	     pst.setString(4, u.getPassword());
	     pst.setDouble(5, u.getter());
	     pst.executeUpdate();
	     obj.transaction(u);
	     System.out.println("Thank you Account Created Successfully");
	     System.out.println("Login to check");  
	     Login user=new Login();
	     user.checker();
	}  
	
	
}
