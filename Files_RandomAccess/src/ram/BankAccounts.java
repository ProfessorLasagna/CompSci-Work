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

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BankAccounts extends EasyApp {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new BankAccounts();

	}

	Button bWrite = addButton("Write Record", 30, 30, 100, 50, this);
	Button bRead = addButton("Read Record", 130, 30, 100, 50, this);
	Button bReadall = addButton("Show all Records", 230, 30, 100, 50, this);
	Button bAddmoney = addButton("Deposit", 30, 120, 100, 50, this);
	Button bRemovemoney = addButton("Withdrawal", 130, 120, 100, 50, this);


	public void actions(Object source, String command) {

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

	}

	public void writeRecord() {

		try {

			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for saving the data:");

			String name = input("Type the customer's name:");

			int pin = inputInt("4-digit PIN");

			double money = inputDouble("Type the customer's money:");

			file.seek(40 * pos);
			file.writeUTF(name);
			file.seek(40 * pos + 25);
			file.writeInt(pin);
			file.seek(40 * pos + 30);
			file.writeDouble(money);

			file.close();
		} catch (IOException ex) {
			
			output(ex.toString());

		}
		
	}

	public void readRecord() {	
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "r");
			long pos = inputLong("Type the record number for reading the data:");

			file.seek(40 * pos);
			String name = file.readUTF();
			file.seek(40 * pos + 25);
			int pin = file.readInt();
			file.seek(40 * pos + 30);
			double money = file.readDouble();

			output("Record #" + pos + " = " + name + " | " + pin + " | $" + money);

			file.close();
		
		} catch (IOException ex) {
			
			output(ex.toString());
		
		}
		
	}
	
	public void showAllRecords(){
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "r");

			long length = (file.length()) / 39;
			
			for(long pos1 = 0; pos1 < length; pos1++){
				
				file.seek(40 * pos1);
				String name = file.readUTF();
				file.seek(40 * pos1 + 25);
				int pin = file.readInt();
				file.seek(40 * pos1 + 30);
				double money = file.readDouble();
				
				if(pin != 0){
					
					output("Record #" + pos1 + " = " + name + " | $" + money);

				}
				
			}
			
			file.close();
			
		} catch (IOException ex) {
			
			output(ex.toString());
		
		}
		
	}
	
	public void addMoney(){
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for the account deposit:");
			
			file.seek(40 * pos + 30);
			double currentmoney = file.readDouble();
			double money = inputDouble("Type the money to be added:");
			
			currentmoney = currentmoney + money;
			
			file.seek(40 * pos + 30);
			file.writeDouble(currentmoney);
		
			file.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		}
						
	}

	public void removeMoney(){
		
		try {
			
			RandomAccessFile file = new RandomAccessFile("bank.dat", "rw");
			long pos = inputLong("Type the record number for the account withdrawal:");
			
			file.seek(40 * pos + 30);
			double currentmoney = file.readDouble();
			double money = inputDouble("Type the money to be removed:");
			
			currentmoney = currentmoney - money;
			
			file.seek(40 * pos + 30);
			file.writeDouble(currentmoney);
		
			file.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		}
		
	}
	
}