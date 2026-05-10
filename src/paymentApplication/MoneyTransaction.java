package paymentApplication;

import java.util.Scanner;

public class MoneyTransaction implements Transactions{
@Override
	public void check_account_balance() {
		// TODO Auto-generated method stub
		
	}
@Override
	public void send_money(double amount,User u_receiver,User u_sender) {
		// TODO Auto-generated method stub
          if(amount>u_sender.getter()) {
        	  System.out.println("Low Balance Please deposit money in your account");
          }
          else {
        	 double sender_balance=u_sender.getter();
        	 double receiver_balance=u_receiver.getter();
        	 double credit=receiver_balance+amount;
        	 double debit=sender_balance-amount;
        	 u_sender.setter(debit);
        	 u_receiver.setter(credit);
             AfterTransactiondbupdate obj=new AfterTransactiondbupdate();
             obj.db_upadate(u_sender, u_receiver);
           }
	}
Scanner sc=new Scanner(System.in);
void Transaction(User u_sender){
	System.out.println("Select the transaction you want to perform");
    System.out.println("1.Money Transfer");
    System.out.println("2.Check Balance");
    System.out.println("Enter digit from 1 or 2 select the transaction");
    int choice=sc.nextInt();
    //Transaction_validation(choice);
    if(choice==1) {
              Receiversuser u_receiver=new Receiversuser();
              u_receiver.details(u_sender);
    	    }
}

void Transaction_validation(int choice) {
	if(choice!=1 || choice!=2) {
    	System.out.println("Please select valid Transaction");
    	Transaction_validation(choice);
    }
}
}
