package Module;

public class User {
  private double balance;
  private String name;
  private String upi_id;
 
  public void setter(double balance) {
	  this.balance=balance;
  }
  public double getter() {
	  return this.balance;
  }
   
   public User(String name,String upi_id){
	   this.name=name;
	   this.upi_id=upi_id;
   }
   public User(String name,String upi_id,double balance){
	 this.name=name;
	 this.upi_id=upi_id;
	 this.balance=balance;
   }
   
}
