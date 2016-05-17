package ram;

//== Create a RandomAccessFile ==
//Creates a RandomAccessFile with names, PIN and money
//The program allocates 40 bytes for each recored -
//25 bytes for the name field
//5  bytes for the PIN
//10 bytes for the money
//The commands .writeUTF and .readUTF use the following system:
//First two bytes tell the length of the following string,
// and the following bytes contain the string (1 char per byte)
//The int value occupies 4 bytes (32 bits), but we allocate 5.
//The double value occupies 8 bytes, but we allocate 10.
//So we must allocate a total of 40 bytes for one record.
//If shorter strings are recorded, the extra bytes are empty (wasted) and ignored.
//==================================================================================
import java.awt.Button;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;

public class BankAccounts extends EasyApp {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new BankAccounts();

	}//End main

	Button bWrite = addButton("Write Record", 30, 30, 100, 50, this);
	Button bRead = addButton("Read Record", 130, 30, 100, 50, this);
	Button bReadall = addButton("Show all Records", 230, 30, 100, 50, this);
	Button bAddmoney = addButton("Deposit", 30, 120, 100, 50, this);
	Button bRemovemoney = addButton("Withdrawal", 130, 120, 100, 50, this);
	Button bMonthlyfee = addButton("Apply Monthly Fee", 230, 120, 100, 50, this);
	Button bMonthlyInterest = addButton("Apply Interest", 30, 220, 100, 50, this);
	Button bMonthlyUpdate = addButton("Monthly Update", 130, 220, 100, 50, this);
	Button bExit = addButton("Exit", 230, 220, 100, 50, this);
	//Adds all of the buttons to the program
	
	public void actions(Object source, String command) {
		//Links every button to the defined method

		if (source == bWrite) {
			writeRecord();
		}
		
		if (source == bRead) {
			readRecord();
		}
		
		if(source == bReadall){
			showAllRecords();						
		}
		
		if(source == bAddmoney){
			addMoney();					
		}
		
		if(source == bRemovemoney){
			removeMoney();
		}
		
		if(source == bMonthlyfee){
			monthlyFee();
		}
		
		if(source == bMonthlyInterest){
			monthlyInterest();
		}
		
		if(source == bMonthlyUpdate){
			monthlyUpdate();
		}
		
		if(source == bExit){
			output("Goodbye!");
			System.exit(0);
		}

	}//End actions

	public void writeRecord() {
		//Used to create new bank accounts

		try {

			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for saving the data:");
			//Accepts the user's input for the account number

			String name = input("Type the customer's name:");
			//Accepts the user's name

			int pin = inputInt("4-digit PIN");

			double money = inputDouble("Type the customer's money:");

			file.seek(40 * pos); //The program then moves through the bank.dat file and writes the user's
			file.writeUTF(name); //input values to the chosen memory locations
			file.seek(40 * pos + 25);
			file.writeInt(pin);
			file.seek(40 * pos + 30);
			file.writeDouble(money);

			file.close();
			
		} catch (IOException ex) {
			
			output(ex.toString());

		}
		
	}//End writerecord

	public void readRecord() {	
		//Use to let the user enter the account number and the program will return all of the accounts data
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "r");
			long pos = inputLong("Type the record number for reading the data:");
			//Allows the user to select the account

			file.seek(40 * pos); //Moves to that location and begins collecting all of the data
			String name = file.readUTF();
			file.seek(40 * pos + 25);
			int pin = file.readInt();
			file.seek(40 * pos + 30);
			double money = file.readDouble();

			DecimalFormat df = new DecimalFormat("###.##");
			//Used so that the program only prints the user's balance to two decimal points
			
			output("Record #" + pos + " = " + name + " | " + pin + " | $" + df.format(money));

			file.close();
		
		} catch (IOException ex) {
			
			output(ex.toString());
		
		}
		
	}//End readrecord
	
	public void showAllRecords(){
		//Used to display every single account located in the bank.dat file
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "r");

			long length = (file.length()) / 39;
			//Determines how many accounts to display
			
			for(long pos1 = 0; pos1 < length; pos1++){
				//Prints as many accounts as the previous code could find
				
				file.seek(40 * pos1); //Collects the data for the accounts in order
				String name = file.readUTF();
				file.seek(40 * pos1 + 25);
				int pin = file.readInt();
				file.seek(40 * pos1 + 30);
				double money = file.readDouble();
				
				DecimalFormat df = new DecimalFormat("###.##");
				//Used so that the program only prints the user's balance to two decimal points
				
				if(pin != 0){
					//Used to skip over empty accounts
					
					output("Record #" + pos1 + " = " + name + " | $" + df.format(money));

				}
				
			}
			
			file.close();
			
		} catch (IOException ex) {
			
		}
		
	}//End showallrecords
	
	public void addMoney(){
		//Used to allow the user to make a deposit on an account
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for the account deposit:");
			//Allows the user to select the account they will make a deposit on
			
			file.seek(40 * pos + 30); //Gathers the necessary data for the deposit to be made
			double currentmoney = file.readDouble();
			double money = inputDouble("Type the money to be added:");
			//Allows the user to input how much money will be deposited
			
			currentmoney = currentmoney + money;
			//Adds the deposit to the user's money
			
			file.seek(40 * pos + 30); //Overwrites the prvious balance with the new balance
			file.writeDouble(currentmoney);
		
			file.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		}
						
	}//End addmoney

	public void removeMoney(){
		//Allows the user to make a withdrawal from a chosen account
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for the account withdrawal:");
			//Allows the user to select the account used for the withdrawal
			
			file.seek(40 * pos + 30); //Gathers the necessary data used for the withdrawal
			double currentmoney = file.readDouble();
			double money = inputDouble("Type the money to be removed:");
			//Allows the user to enter how much money to withdraw
			
			currentmoney = currentmoney - money;
			//Subtracts the value from the accounts balance
			
			file.seek(40 * pos + 30); //Overwrites the previous balance with the new balance
			file.writeDouble(currentmoney);
		
			file.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		}
		
	}//End removemoney
	
	public void monthlyFee(){
		//Used to subtract the monthly fee from all accounts

		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			
			for(long pos = 0; pos  < 1000; pos++){	
				//Subtracts this value from all accounts
			
				file.seek(40 * pos + 30); //Retrieves the current accounts data
				double currentmoney = file.readDouble();
				file.seek(40 * pos);
				String name = file.readUTF();
				file.seek(40 * pos + 25);
				int pin = file.readInt();
				
				if(pin != 0)//Only subtract the amount if the account exists
					currentmoney = currentmoney - 50;
				
				DecimalFormat df = new DecimalFormat("###.##");
				//Used so that the program only prints the user's balance to two decimal points
				
				if(currentmoney < 0 && pin != 0) //If the account exists and has now has a negative balance
					output(name+" has gone into the negative! Current balance: $"+df.format(currentmoney)+" Account number: " +pos);
				
				file.seek(40 * pos + 30); //Overwrites the previous balance with the new balance
				file.writeDouble(currentmoney);
			
			}
						
			file.close();
		
		} catch (IOException ex) {
			
			output("Monthly fee Applied!");
			
		}	
		
		
	}//End monthlyfee

	public void monthlyInterest(){
		//Used to add the monthly interest to all user's accounts
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			
			for(long pos = 0; pos  < 1000; pos++){	
				//Used to add to all accounts
			
				file.seek(40 * pos + 30); //Retrieves the current accounts data
				double currentmoney = file.readDouble();
				file.seek(40 * pos + 25);
				int pin = file.readInt();
				
				if(pin != 0) //If the account exists
					currentmoney = currentmoney*1.005;
				
				file.seek(40 * pos + 30); //Overwrites the previous balance with the new balance
				file.writeDouble(currentmoney);
			
			}
						
			file.close();
		
		} catch (IOException ex) {
			
			output("Monthly interest Applied!");
			
		}	
				
	}//End monthlyinterest
	
	public void monthlyUpdate(){
		//Used to apply both the interest and fee in one button 
		//(fairly redundant to have this and the other two methods at the same time)
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			
			for(long pos = 0; pos  < 1000; pos++){	
				//Runs through all of the accounts
			
				file.seek(40 * pos + 30); //Retrieves all of the accounts data
				double currentmoney = file.readDouble();
				file.seek(40 * pos);
				String name = file.readUTF();
				file.seek(40 * pos + 25);
				int pin = file.readInt();
				
				if(pin != 0) //If the account exists
					currentmoney = (currentmoney - 50)*1.005; //Applies both the fee and the interest
				
				DecimalFormat df = new DecimalFormat("###.##");
				//Used so that the program only prints the user's balance to two decimal points
				
				if(currentmoney < 0 && pin != 0) //If the account exists and has gone into the negative
					output(name+" has gone into the negative! Current balance: $"+df.format(currentmoney)+" Account number: " +pos);
				
				file.seek(40 * pos + 30); //Overwrites the accounts previous baance with the new balance
				file.writeDouble(currentmoney);
			
			}
						
			file.close();
		
		} catch (IOException ex) {
			
			output("Monthly update Applied!");
			
		}	
		
	}//End monthly update
	
}