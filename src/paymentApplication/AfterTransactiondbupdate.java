package paymentApplication;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class AfterTransactiondbupdate  {
    void db_upadate(User u_sender,User u_receiver) {
    	
        try {
    	 Statement st=DBCONNECTION.connection().createStatement(); 
    	 String query="update user set balance =" +u_sender.getter()+" where upi_id= '"+u_sender.getUpi_id()+"'";
    	 st.execute(query);
    	 String query1="update user set balance =" +u_receiver.getter()+" where upi_id='"+u_receiver.getUpi_id()+"'";
    	 st.execute(query1);
        }
        catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
        }
        }          
}
