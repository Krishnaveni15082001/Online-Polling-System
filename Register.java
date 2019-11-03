import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import first.Functions.ageNotValid;
import first.Functions.passwordStrength;

public class Register {
	
	Scanner scan = new Scanner(System.in);
	Functions functions = new Functions();
	int choice, key;
	
	@SuppressWarnings("unchecked")
	public void voterRegister() throws IOException {
		
		List<Voter> voterList = new ArrayList<Voter>();
		String voterName, pass1, pass2;
		int vAge;		
		
		try {
			FileInputStream fileInputStream = new FileInputStream("Voter.txt");		
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			voterList = (ArrayList<Voter>)objectInputStream.readObject();
			fileInputStream.close();
			objectInputStream.close();
		}
		catch(Exception ex) {}
		
		FileOutputStream fileOutputStream = new FileOutputStream("Voter.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		do {
			System.out.println("Enter Voter Name: ");
			voterName = scan.next();
			System.out.println("Enter Voter Age: ");
			vAge = scan.nextInt();
			try {
				functions.checkVoterAge(vAge);
				System.out.println("Enter password : ");
				pass1 = scan.next();
				System.out.println("Re-enter password : ");
				pass2 = scan.next();
				
				if(pass1.equals(pass2) ) {
					try {
						functions.checkPasswordStrength(pass1);
						int id = 0;
						for(Voter voter : voterList) {
							id = voter.getVoterId();
						}
						Voter VOTER = new Voter(voterName, vAge, pass1);
						if(voterList.isEmpty())
							VOTER.setVoterId(1000);
						else
							VOTER.setVoterId(++id);
						voterList.add(VOTER);
						objectOutputStream.writeObject(voterList);
						System.out.println("Voter registered!");
						System.out.println(VOTER);												
						break;
					}
					catch(passwordStrength ex){
						System.out.println(ex.getMessage());
					} catch (Exception e) {}
				}
				else {
					System.out.println("Password didn't match! ");
				}		
				
			}//try ends
			catch(ageNotValid ex) {
				System.out.println(ex.getMessage());
			}//catch ends
			
		}while(true);
		objectOutputStream.close();
		fileOutputStream.close();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void nomineeRegister() throws IOException {
		
		boolean check = false;
		//List<Nominee> nomineeList = new ArrayList<Nominee>();
		ArrayList<Nominee> nomineeList1 = new ArrayList<Nominee>();
		String nomineeName;
		int nomineeAge;		
		//Nominee nominee3 = new Nominee(10000, "Krishna", "President", 56);
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		/*FileOutputStream fileOutputStream  = new FileOutputStream("Nominee.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(nominee3);*/
		
		try {
			
			fileInputStream = new FileInputStream("Nominee.txt");		
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			
			
			while(true) {
				try {
					nomineeList1 = (ArrayList<Nominee>) objectInputStream.readObject();
					//nomineeList1.add((Nominee) objectInputStream.readObject());
				} catch (Exception e) {
					//e.printStackTrace();
					//System.out.println(nomineeList1);
					break;
				}
				
			}
			/*while((nominee2 = (Nominee) objectInputStream.readObject()) != null) {
				nomineeList.add(nominee2);
			}*/
			//nomineeList = (ArrayList<Nominee>)objectInputStream.readObject();
			//System.out.println(nomineeList1);
			//fileInputStream.close();
			//objectInputStream.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("In catch!");
		}
		
		finally {
			//fileInputStream.close();
			//objectInputStream.close();
		}
		
		FileOutputStream fileOutputStream  = new FileOutputStream("Nominee.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		do {
			System.out.println("Enter Nominee Name: ");
			nomineeName = scan.next();
			System.out.println("Enter Nominee Age: ");
			nomineeAge = scan.nextInt();
			Nominee nominee = new Nominee();
			
			try {
				functions.checkNomineeAge(nomineeAge);
				System.out.println("Available positions");
				functions.displayNomineeMenu();
				choice = scan.nextInt();
				
				nominee.setNomName(nomineeName);
				nominee.setNomAge(nomineeAge);
				
				switch(choice) {
					case 1:
						nominee.setNomPosition("President");
						check = true;break;
					case 2:
						nominee.setNomPosition("Prime Minister");
						check = true;break;
					case 3:
						nominee.setNomPosition("Chief Minister");
						check = true;break;
				}//switch
				
				
				//try {
					//System.out.println("In Try");
					int id = 0;
					if(nomineeList1.isEmpty()) {
						//throw new Exception("Exception");
						nominee.setNomId(10000);
					}
					else {
						nominee.setNomId(nomineeList1.size() + 10000);
					}
					nomineeList1.add(nominee);
					objectOutputStream.writeObject(nomineeList1);
					System.out.println("Nominee added!");
					System.out.println(nomineeList1);
					System.out.println(nominee);
					/*for(Nominee nominee1 : nomineeList1) {
						System.out.println("In for");
						id = nominee1.getNomId();
					}
					nominee.setNomId(++id);
					
						/*nomineeList1.add(nominee);
						System.out.println("Nominee added!");
						System.out.println(nominee);
						objectOutputStream.writeObject(nomineeList1);
						System.out.println("Nominee registered!");
						System.out.println(nominee);*/												
						//break;
					//}//try ends
					
					//catch (Exception e) {
						//nominee.setNomId(10000);
						//e.printStackTrace();
					//}
				
				/*finally {
					
					nomineeList1.add(nominee);
					objectOutputStream.writeObject(nomineeList1);
					System.out.println("Nominee added!");
					System.out.println(nomineeList1);
					System.out.println(nominee);
				//}*/
				
				
			}//main-try

			catch(ageNotValid ex) {
				System.out.println(ex.getMessage());
			}//catch ends
		
			
		}while(check == false);
		
		fileInputStream.close();
		objectInputStream.close();
		objectOutputStream.close();
		fileOutputStream.close();
	}
}