package Module;


import java.util.Scanner;

public class BankTransfer implements Paymentmethod {
    Scanner sc=new Scanner(System.in);
   
	@Override
	public void processpayment(User u, double amount) {
		// TODO Auto-generated method stub
      u.setter(amount);
      System.out.println("Transaction Succesful : Money amount Transfered : "+u.getter());
	}
   public void receiversdetails(User u) {
	   
	   System.out.println("Enter Receiver name");
	   String name=sc.next();
      System.out.println("Enter Recievers Upi_id");
      sc.nextLine(); 
      String reivers_upi_id=sc.nextLine();
      System.out.println("Enter Amount");
      double amount=sc.nextDouble();
      try {
      if(u.getter()<amount) {
    	  throw new Insuffiecientbalance("Low balance");
      }
      else {
    	  u.setter(u.getter()-amount);
    	  User receiver=new User(name,reivers_upi_id);
    	  processpayment(receiver, amount);
    	  System.out.println("Remaining balance : "+u.getter());
      }
      }
      catch (Exception e) {
		// TODO: handle exception
	   //System.out.println("Low balance");
      }
      }
   
    
}
