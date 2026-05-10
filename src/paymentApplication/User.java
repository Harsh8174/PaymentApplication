package paymentApplication;


	public class User {
		  private double balance;
		  private String name;
		  private String upi_id;
          private String upi_pin;
          private String password;
		  public void setter(double balance) {
			  this.balance=balance;
		  }
		  public double getter() {
			  return this.balance;
		  }
		  
		   public User(String name,String upi_id,String pin,String password){
			   this.name=name;
			   this.upi_id=upi_id;
			   this.upi_pin=pin;
			   this.password=password;
		   }
		   public User(String name,String upi_id,double balance,String pin,String password){
			 this.name=name;
			 this.upi_id=upi_id;
			 this.balance=balance;
			 this.upi_pin=pin;
			 this.password=password;
		   }
		   public String getName() {
			   return name;
		   }
		   public void setName(String name) {
			   this.name = name;
		   }
		   public String getUpi_id() {
			   return upi_id;
		   }
		   public void setUpi_id(String upi_id) {
			   this.upi_id = upi_id;
		   }
		   public String getUpi_pin() {
			   return upi_pin;
		   }
		   public void setUpi_pin(String upi_pin) {
			   this.upi_pin = upi_pin;
		   }
		   public String getPassword() {
			   return password;
		   }
		   public void setPassword(String password) {
			   this.password = password;
		   }
		   @Override
		   public String toString() {
			return "User [balance=" + balance + ", name=" + name + ", upi_id=" + upi_id + ", upi_pin=" + upi_pin
					+ ", password=" + password + "]";
		   }
		   
		}


