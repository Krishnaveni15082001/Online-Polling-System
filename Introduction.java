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

public class Introduction {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		int ch, key = 0;
		Functions functions = new Functions();
		LoginVoter login = new LoginVoter();
		Register register = new Register();
		Scanner scan = new Scanner(System.in);
		

		do {
			
			functions.displayMainMenu();			
			ch = scan.nextInt();
			
			switch(ch) {
			
				case 1:
					login.login();
					break;					
					
				case 2:					
					functions.displayRegisterMenu();					
					key = scan.nextInt();
					
					switch(key) {
					
						case 1:		register.voterRegister();
									break;
															
						case 2:		
									register.nomineeRegister();
									break;
							
						case 3:		break;				
					}	
					
				case 3:
					break;
				default:
					System.out.println("Wrong selection made!");
			}
		}while(ch !=3);
		
		
	}
}