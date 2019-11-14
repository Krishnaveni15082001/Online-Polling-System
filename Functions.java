package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import first.Functions.ageNotValid;
import first.Functions.passwordStrength;

@SuppressWarnings("unused")
public class Functions {
	Scanner scan = new Scanner(System.in);
	Nominee nominee = null;
	
	@SuppressWarnings("serial")
	public class ageNotValid extends Exception{
		public ageNotValid(String message) {
			super(message);
		}		
	}//ageNotValid exception ends
	
	public int checkVoterAge(int age) throws ageNotValid {
		if(age < 18) {
			throw new ageNotValid("Voter age shouldn't be less than 18.");
		}
		return 1;
	}
	
	public int checkNomineeAge(int age) throws ageNotValid {
		if(age < 35) {
			throw new ageNotValid("Nominee age shouldn't be less than 35.");			
		}
		return 1;
	}
	
	@SuppressWarnings("serial")
	public class passwordStrength extends Exception{
		public passwordStrength(String message) {
			System.out.println(message);
		}
	}//passwordStrength exception ends
	
	public int checkPasswordStrength(String Password) throws passwordStrength{
		if(Password.length() < 8) {
			throw new passwordStrength("Password must contain atleast 8 characters.");
		}
		return 1;		
	}
	
	@SuppressWarnings("serial")
	public class voterRegister extends Exception{
		
		public voterRegister(String message) {
			System.out.println(message);
		}
	}
	
	public boolean voterRegistration(Voter voter) throws voterRegister{
		
		if(voter == null) {
			throw new voterRegister("Voter not registered!");
		}
		return true;
	}
	
	public void displayNomineeMenu() {
		
		System.out.println("Choose accordingly\n1. MLA\n2. MP");
	
	}
	
	public void displayStatesMenu() {
		System.out.println("Choose accordingly\n1. Telangana\n2. Andhra Pradesh\n3. Maharashtra");
	}
	
	public void displayLoginMenu() {
		
		System.out.println("1 . Cast your vote. ");
		System.out.println("2 . List of Nominees. ");
		System.out.println("3 . Go back to main menu. ");
		System.out.println("Select any option: ");
	
	}
	
	@SuppressWarnings("resource")
	public void displayNominee() throws IOException, Throwable {
		
		FileInputStream fileInputStream1 = new FileInputStream("Nominee.txt");
		ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
		Nominee nominee = (Nominee) objectInputStream1.readObject();
		
		if(nominee == null) {
			System.out.println("No nominees registered yet!");
		}
		else {
			System.out.println(nominee);
			while((nominee = (Nominee) objectInputStream1.readObject()) != null) {
				System.out.println(nominee);
			}
		}
	}
	
	public void displayMainMenu() {
		
		System.out.println("Welcome to Internal Poling System!\n");
		System.out.println("Enter 1 for login.");
		System.out.println("Enter 2 for registering. ");
		System.out.println("Enter 3 for admin login. ");
		System.out.println("Enter 4 to exit!");
	
	}
	
	public void displayRegisterMenu() {
		
		System.out.println("1. Register as Voter");
		System.out.println("2. Go back to main menu");
		System.out.println("Select any option: ");
	
	}	
	
	public void adminLogin() throws ClassNotFoundException, IOException {
		String id, pass;
		Admin admin = new Admin();
		
		System.out.println("Enter Id: ");
		id = scan.next();
		System.out.println("Enter Password: ");
		pass =scan.next();
		
		admin.adminLogin(id, pass);		
	}
	
	public void adminLoginMenu() throws ClassNotFoundException, IOException {
		int n;
		Admin admin = new Admin();
		Register register = new Register();
		System.out.println("Choose accordingly\n1. Check results\n2. Add nominee\n3. Go back to main menu");
		n = scan.nextInt();
		
		if(n == 1)
			admin.checkResults();
		else if(n == 2)
			register.nomineeRegister();
			
			
	}
	
}