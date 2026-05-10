package paymentApplication;

public interface Transactions {
   void send_money(double amount,User u_receiver,User u_sender);
   void check_account_balance();
}
