package bank.storage;

public class Account {

	private double balance;
	private Customer cust;

	public Account(double bal, String fName, String sName, String city, String str, String pro, String post){

		balance = bal;

		cust = new Customer(fName, sName, city, str, pro, post);

	}

	public void changeAddress(String str, String city, String prov, String post){

		cust.changeStreet(str);
		cust.changeCity(city);
		cust.changePost(post);
		cust.changeProvince(prov);

	}

	public double getBalance(){

		return(balance);

	}

	public void deposit(double input){

		balance += input;

	}

	public void withdrawl(double input){

		if(input > balance){
			System.out.println("Sorry, there are not enough funds in your account to make a withdrawl.");
		}else{
			balance -= input;
		}

	}

	public String toString(){

		String custString;

		custString = "Customer data: \n"+cust;
		custString += "\nBalance: $"+balance;

		return(custString);

	}
	
}
