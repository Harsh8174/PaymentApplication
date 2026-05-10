package Module;

import java.util.Scanner;
import Module.User;
public class UPI {
	Scanner sc=new Scanner(System.in);
     
     User userinput() {
		 System.out.println("Select the opration to be perfomed");
         System.out.println("1.Money Transfer");
         System.out.println("2.Check Balance");
         String input=sc.nextLine();
         String str="1.Money Transfer";
         if(input.equalsIgnoreCase(str)) {
             System.out.println("Enter user name");        	
             String name=sc.next();  
        	 System.out.println("Enter upi_id");
        	 String upi_id=sc.next();
        	 mask_upiid(upi_id);
        	 System.out.println("Want to create premium account");
        	 System.out.println("Yes");
        	 System.out.println("No");
        	 String premium=sc.next();
           	User u= accountcreation(premium, name, upi_id); 	  
             return u;
         }
         else {
        	 System.out.println("select valid operation");
             userinput();
         }
         return null;
	}
	
	  User accountcreation(String premium,String name,String upi_id) {
		  if(premium.trim().equalsIgnoreCase("yes")){
			 System.out.println("Enter minimum balance you want to keep inside wallet");
			 double wallbal=sc.nextDouble();
			 if(wallbal>500) {
				  User u=new User(name,upi_id,wallbal); 
			     return u;
			 }
			 else {
				 System.out.println("Minimum balance to kept is 500");
				 accountcreation(premium, name,upi_id);
			 }
		  }
		  else {
			    User u=new User(name,upi_id);	    
			    return u;
		  }
		  return null;
	  }
	  
	   void transaction(User u) {
		       System.out.println("Select Transaction to performed");
		       System.out.println("1.Bank Transfer");
		       System.out.println("2.Bank balanace check");
		       System.out.println("3.Wallet Transfer");
		       System.out.println("4.Wallet balance check");
		       System.out.println("Enter digit to select");
		       sc.nextLine();
		       int choice=sc.nextInt();
		       switch(choice) {
		       case 1:BankTransfer bt=new BankTransfer();
		               bt.receiversdetails(u);
		       }
		      
	   }
	   void mask_upiid(String upi_id) {
		  String starting=upi_id.substring(0, upi_id.length()-4);
          String maskup="";		  
		  for(int i=0;i<starting.length();i++) {
			  maskup+="*";
		  }
		  for(int i=upi_id.length()-4;i<upi_id.length();i++) {
			  maskup+=upi_id.charAt(i);
		  }
		  System.out.println(maskup);
	   }
	public static void main(String[] args) {
		 UPI user=new UPI();
    	 User u=user.userinput();
    	 user.transaction(u);
	}
}
