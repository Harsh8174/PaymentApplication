package TransactionHistory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.sql.Timestamp;
import paymentApplication.DBCONNECTION;
import paymentApplication.User;

public class Transactionhistory {
   public void transaction(User u) {
	   String query="Insert into transaction_history(upi_id,balance,Transaction_Time,Transaction_Status) values(?,?,?,?)";
	   try {
		   	   PreparedStatement pst=DBCONNECTION.connection().prepareStatement(query);
		   	   pst.setString(1, u.getUpi_id());
		   	   pst.setDouble(2, u.getter());
		   	   Timestamp obj=new Timestamp(System.currentTimeMillis());
		   	   pst.setTimestamp(3,obj);
		   	   pst.setString(4, "Success");
	           pst.executeUpdate();
	      }
	   catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
	   }
   
    public void transfer(User u_sender,User u_receiver){
    	Timestamp obj=new Timestamp(System.currentTimeMillis());
    	   String s_query="insert into transaction_history(upi_id,balance,Transaction_Time,Transaction_Status)values(?,?,?,?)";
    	   String r_query="insert into transaction_history(upi_id,balance,Transaction_Time,Transaction_Status)values(?,?,?,?)";
    	   try {
    	   PreparedStatement s_pst=DBCONNECTION.connection().prepareStatement(s_query);
    	   PreparedStatement r_pst=DBCONNECTION.connection().prepareStatement(r_query);
    	   s_pst.setString(1, u_sender.getUpi_id());
    	   s_pst.setDouble(2, u_sender.getter());
    	   s_pst.setTimestamp(3, obj);
    	   s_pst.setString(4, "success");
    	   s_pst.executeUpdate();
    	   r_pst.setString(1, u_receiver.getUpi_id());
    	   r_pst.setDouble(2, u_receiver.getter());
    	   r_pst.setTimestamp(3, obj);
    	   r_pst.setString(4, "success");
    	   r_pst.executeUpdate();
    	   }
    	   catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
    	   }
    }
    
    public void history_fetching(User u){
   	        String query="select * from transaction_history where upi_id=?";
   	        Filewriter obj=new Filewriter();
   	        try {
   	        PreparedStatement pst= DBCONNECTION.connection().prepareStatement(query);
   	        pst.setString(1, u.getUpi_id());
   	        ResultSet rst=pst.executeQuery();
   	     String  str="";
   	        while(rst.next()){
   	            
   	            str+="\n"+rst.getString("upi_id")+"  "+rst.getDouble("balance")+"  "+rst.getTimestamp("Transaction_Time")+"  "+rst.getString("Transaction_Status"); 	
   	            obj.writer(str);
   	        }
   	        }
   	        catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
   	        }
   	        
    }
}
    