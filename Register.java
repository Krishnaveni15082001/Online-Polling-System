package first;

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

public class Register extends Nominee{

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
						Voter voter1 = new Voter(voterName, vAge, pass1);
						if(voterList.isEmpty())
							voter1.setVoterId(1000);
						else
							voter1.setVoterId(++id);
						voterList.add(voter1);
						objectOutputStream.writeObject(voterList);
						System.out.println("Voter registered!");
						System.out.println(voter1);												
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
		ArrayList<Nominee> nomineeList1 = new ArrayList<Nominee>();
		String nomineeName;
		int nomineeAge;		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;


		try {

			fileInputStream = new FileInputStream("Nominee.txt");		
			objectInputStream = new ObjectInputStream(fileInputStream);
			while(true) {
				try {
					nomineeList1 = (ArrayList<Nominee>) objectInputStream.readObject();

				} catch (Exception e) {					
					break;
				}

			}

		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("In catch!");
		}

		finally {

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
					nominee.setNomPosition("MLA");
					check = true;break;
				case 2:
					nominee.setNomPosition("MP");
					check = true;break;
				
				}//switch
				
				
				
				functions.displayStatesMenu();
				choice = scan.nextInt();
				
				switch(choice) {
				case 1:
					nominee.setNomState("Telangana");
					System.out.println("Choose accordingly\n1. Khammam\n2. Medak\n3. Ranga Reddy");
				    int choice = scan.nextInt();
					switch(choice) {
					case 1:
					nominee.setNomTelanganaDistrict("Khammam");
					break;
					
				    case 2:
				    	nominee.setNomTelanganaDistrict("Medak");
					    break;
				case 3:
					    nominee.setNomTelanganaDistrict("Ranga Reddy");
					    break;
				}//switch
					break;
					
				case 2:
					nominee.setNomState("Andhra Pradesh");
					System.out.println("Choose accordingly\n1. Guntur\n2. Nellore\n3. Anantapur");
					int choice1 = scan.nextInt();
					switch(choice1) {
					case 1:
						nominee.setNomAndhraDistrict("Guntur");
						break;
						
					case 2:
						nominee.setNomAndhraDistrict("Nellore");
						break;
					case 3:
						nominee.setNomAndhraDistrict("Ananthapur");
						break;
						}//switch
					break;
				
				case 3:
					nominee.setNomState("Maharashtra");
					System.out.println("Choose accordingly\n1. Nagpur\n2. Pune\n3. Satara");
					int choice2 = scan.nextInt();
					switch(choice2) {
					case 1:
						nominee.setNomMaharastraDistrict("Nagpur");
						break;
						
					case 2:
						nominee.setNomMaharastraDistrict("Pune");
						break;
					case 3:
						nominee.setNomMaharastraDistrict("Satara");
						break;
					}//switch
					break;
				}//switch
				

				int id = 0;
				if(nomineeList1.isEmpty()) {

					nominee.setNomId(10000);
				}
				else {
					nominee.setNomId(nomineeList1.size() + 10000);
				}
				nomineeList1.add(nominee);
				objectOutputStream.writeObject(nomineeList1);
				System.out.println("Nominee added!");
				System.out.println(nominee);



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






//List<Nominee> nomineeList = new ArrayList<Nominee>();
/*FileOutputStream fileOutputStream  = new FileOutputStream("Nominee.txt");
ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject(nominee3);*/
/*while((nominee2 = (Nominee) objectInputStream.readObject()) != null) {
nomineeList.add(nominee2);
}*/
//nomineeList = (ArrayList<Nominee>)objectInputStream.readObject();
//System.out.println(nomineeList1);
//fileInputStream.close();
//objectInputStream.close();
//nomineeList1.add((Nominee) objectInputStream.readObject());
//e.printStackTrace();
//System.out.println(nomineeList1);
//fileInputStream.close();
//objectInputStream.close();
//try {
//System.out.println("In Try");
//throw new Exception("Exception");
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
