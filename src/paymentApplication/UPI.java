package paymentApplication;

import java.util.Scanner;

public class UPI {
  Scanner sc=new Scanner(System.in);
      void senderaccountchecker() {
    	System.out.println("Welcome to PBM Upi app");
  		System.out.println("1.Create New Account");
  		System.out.println("2.Login into Account");
        System.out.println("Enter choice in digit ");
  		int choice=sc.nextInt();
  		switch(choice) {
  		case 1: CreateAccount Registeruser=new CreateAccount();
  		    try {    
  		Registeruser.account_database_Storage();
  		    }
  		    catch(Exception e) {
  		    	e.printStackTrace();
  		    }
  		break;
  		case 2: Login user=new Login();
  		        try {
  		        	user.checker();
  		        }
  		        catch (Exception e) {
					// TODO: handle exception
				e.printStackTrace();
  		        }
  		break;	
  		}
      }
      
	
	public static void main(String[] args) {
		
		UPI user=new UPI();
	   try {
		   DBCONNECTION.loaddriver();
		   DBCONNECTION.connection();
		   user.senderaccountchecker();
	   }
	   catch (Exception e) {
		// TODO: handle exception
	   e.printStackTrace();
	   }
	}
	
}
