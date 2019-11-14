package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Admin{


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private int length, t;
	private String  adminId =  "Admin1", adminPass = "Admin1";
	
	@SuppressWarnings("unchecked")
	public void adminLogin(String adminId, String adminPass) throws IOException, ClassNotFoundException {
		Functions functions = new Functions();
		
			
			if(this.adminId.equals(adminId) && this.adminPass.equals(adminPass))
				functions.adminLoginMenu();
		
			else
			System.out.println("Wrong admin details entered!");		
			
	}
	
	public void checkResults() throws IOException, ClassNotFoundException {
		

		FileInputStream fileInputStream = new FileInputStream("Nominee.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		FileInputStream fileInputStream1 = new FileInputStream("Voter.txt");
		ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
		List<Nominee> nomList = new ArrayList<Nominee>();
		List<Voter> voterList = new ArrayList<Voter>();			
		voterList = (ArrayList<Voter>)objectInputStream1.readObject();
		nomList = (ArrayList<Nominee>)objectInputStream.readObject();
		
		int[] nomPresiArray = new int[length];
		
		for(Nominee nominee : nomList) {
			t = 0;
			if(nominee.getNomPosition().equals("MLA")) {
				for(Voter voter : voterList) {
					if(voter.getPresiVote() == nominee.getNomId())
						t = t + 1;
				}
				System.out.println("Number of voter for Nominee "+ nominee.getNomId() + " ( " + nominee.getNomPosition() + "): " + t );
			}
			else if(nominee.getNomPosition().equals("MP")) {
				for(Voter voter : voterList) {
					if(voter.getPmVote() == nominee.getNomId())
						t = t + 1;
				}
				System.out.println("Number of voter for Nominee "+ nominee.getNomId() + " (" + nominee.getNomPosition() + "): " + t );				
			}
			/*else if(nominee.getNomPosition().equals("Chief Minister")) {
				for(Voter voter : voterList) {
					if(voter.getCmVote() == nominee.getNomId())
						t = t + 1;
				}
				System.out.println("Number of voter for Nominee "+ nominee.getNomId() + " ( " + nominee.getNomPosition() + "): " + t );				
			}*/
			
		}
		
		objectInputStream.close();
		fileInputStream.close();
		objectInputStream1.close();
		fileInputStream1.close();
		System.out.println();
		
	}
}