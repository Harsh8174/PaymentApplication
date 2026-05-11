package paymentApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import TransactionHistory.Transactionhistory;
public class MoneyTransaction implements Transactions{
@Override
	public void check_account_balance(User Current_user) throws Exception {
		// TODO Auto-generated method stub
		String query="select * from user where upi_id=?";
	  PreparedStatement pst=DBCONNECTION.connection().prepareStatement(query);
      pst.setString(1, Current_user.getUpi_id());
      ResultSet rst=pst.executeQuery();
      if(rst.next()) {
      System.out.println(rst.getString("user_name")+" : "+rst.getString("balance"));       
      }
      }
@Override
	public void send_money(double amount,User u_receiver,User u_sender) throws Insuffiecientbalance {
		// TODO Auto-generated method stub
          if(amount>u_sender.getter()) {
        	  throw new paymentApplication.Insuffiecientbalance();
          }
          else {
        	  try {
        	  //Connection conn=DBCONNECTION.connection();
        	  //conn.setAutoCommit(false);
        	 double sender_balance=u_sender.getter();
        	 double receiver_balance=u_receiver.getter();
        	 double credit=receiver_balance+amount;
        	 double debit=sender_balance-amount;
        	 u_sender.setter(debit);
        	 u_receiver.setter(credit); 
        	 AfterTransactiondbupdate obj=new AfterTransactiondbupdate();
             obj.db_upadate(u_sender, u_receiver);
             Transactionhistory th=new Transactionhistory();
             th.transfer(u_sender, u_receiver);
           }catch (Exception e) {
			// TODO: handle exception
        	   e.printStackTrace();
		}
          }
	}
Scanner sc=new Scanner(System.in);
void Transaction(User u_sender){
	System.out.println("Select the transaction you want to perform");
    System.out.println("1.Money Transfer");
    System.out.println("2.Check Balance");
    System.out.println("3.Transaction History");
    System.out.println("Enter digit from 1 or 2 select the transaction");
    int choice=sc.nextInt();
    if(choice==1) {
              Receiversuser u_receiver=new Receiversuser();
              u_receiver.details(u_sender);
    	    }
    else if(choice==2){
             MoneyTransaction obj=new MoneyTransaction();
             try {
				obj.check_account_balance(u_sender);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    else {
    	     Transactionhistory obj=new  Transactionhistory();
    	      obj.history_fetching(u_sender);   
    }
}


}
