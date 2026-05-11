package paymentApplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Receiversuser {
Scanner sc=new 	Scanner(System.in);
        void details(User u_sender){
        	System.out.println("Enter receivers Details");
        	System.out.println("Receivers upi_id");
        	try {
        		String upi_id=sc.next();
            database_existance_checking(upi_id,u_sender);
        	}
        	catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
        	}
        	} 
        
        void database_existance_checking(String upi_id,User u_sender) throws Exception{
        	String query="select * from user where upi_id=?";
        	  PreparedStatement pst=DBCONNECTION.connection().prepareStatement(query);
        	   pst.setString(1, upi_id);
        	   ResultSet rst= pst.executeQuery();
        	   boolean isexist=false;
        	   while(rst.next()) {
        		       if(upi_id.equals(rst.getString("upi_id"))) {
        		              isexist=true;
        		    	       MoneyTransaction obj=new MoneyTransaction();
        		               System.out.println("Enter amount to be send");
        		               double amount=sc.nextDouble();
        		               User u_receiver=new User(rst.getString("user_name"), rst.getString("upi_id"), rst.getDouble("balance"), rst.getString("user_pin"),rst.getString("Password"));
        		               try {
        		               obj.send_money(amount,u_receiver,u_sender);
        		               }
        		               catch (Exception e) {
								// TODO: handle exception
							}
        		               }
        	   }
        	   if(!isexist)
        	   {
        	   System.out.println("user not exist in database");
        	   }
        	   }
}
