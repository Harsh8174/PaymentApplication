package TransactionHistory;

import java.io.FileWriter;

public class Filewriter {
	
	void writer(String str){
		try {
	 FileWriter fs=new FileWriter("User_Transaction.txt");
	 fs.write(str);
	 fs.flush();
	 
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		System.out.println("Data stored int file");
		}
 
}
