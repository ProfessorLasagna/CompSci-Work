package bank.storage;

public class Customer {

	private String f, s, c, st, pro, pos;

	public Customer(String fName, String sName, String city, String street, String prov, String post){

		f= fName;
		s = sName;
		c = city;
		st = street;
		pro = prov;
		pos = post;

	}

	public void changeStreet(String newStr){

		st = newStr;

	}

	public void changeCity(String newCity){

		c = newCity;

	}

	public void changeProvince(String newProvince){

		pro = newProvince;

	}

	public void changePost(String newPost){

		pos = newPost;

	}

	public String toString(){

		String custString;

		custString = f +" "+ s +"\n";
		custString += st +"\n";
		custString += c +", "+ pro +" "+ pos +"\n";

		return(custString);

	}

}
