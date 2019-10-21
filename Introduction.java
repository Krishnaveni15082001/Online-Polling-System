package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) {
		int ch, key = 0, toWork, vote, voterId, vAge;
		String pass, pass1, pass2, vName, nPos;
		boolean flag = false, check = false;
		Scanner scan = new Scanner(System.in);
		List<Nominee> nomList = new ArrayList<Nominee>();
		List<Voter> voterList = new ArrayList<Voter>();
		
		do {
			
			System.out.println("Welcome to Online Poling System!");
			System.out.println("");
			System.out.println("Enter 1 for login.");
			System.out.println("Enter 2 for registering. ");
			
			ch = scan.nextInt();
			
			switch(ch) {
			
				case 1:
					
					System.out.print("Enter Voter Id : ");
					voterId = scan.nextInt();
					System.out.println("Enter Password : ");
					pass = scan.next();
					
					for(Voter voter1: voterList) {
						if(voter1.getVoterId() == voterId) {
							check = true;
							
							if(voter1.getPassword().equals(pass)) {
								
								do {
									
									System.out.println("1 . Cast your vote. ");
									System.out.println("2 . List of Nominees. ");
									System.out.println("3 . Go back to main menu. ");
									System.out.println("Select any option: ");
									
									key = scan.nextInt();
									
									switch(key) {
										case 1:
											System.out.println("Enter Voter Id: ");
											toWork = scan.nextInt();
											for(Voter voter:voterList) {
												if(voter.getVoterId() == toWork) {
													System.out.println("Cast your vote to any one Nominee : ");
													vote = scan.nextInt();
													if(vote < (10000 + nomList.size()) && 10000 <= vote) {
														voter.setVote(vote);
														System.out.println("Vote Casted!");
														flag = true;
														//return;
														break;
													}
													else {
														System.out.println("Nominee Id invalid!");
														flag = true;
													}
												}
											}
											if(flag == false) {
												System.out.println("Voter Id Invalid!");
											}
											System.out.println("");
											break;
											
										case 2:
											if(nomList.size() == 0) {
												System.out.println("No nominees registered yet!");
											}
											else {
												System.out.println("Nominee List: ");
												for(Nominee nom:nomList) {
													System.out.println(nom);
												}
											}
											System.out.println("");
											break;
											
										case 3:
											System.out.println("");
											break;
									}
										
								}while(key < 3);
							}
							else {
								System.out.println("Wrong Password!");
							}
						}
					}
					if(check == false) {
						System.out.println("Voter not registered!");
					}
					System.out.println("");
					break;
					
					
				case 2:
					
					System.out.println("1 . Register as Voter");
					System.out.println("2 . Register as Nominee");
					System.out.println("3 . Go back to main menu");
					System.out.println("Select any option: ");
					
					key = scan.nextInt();
					
					switch(key) {
					
						case 1:
								do {
								System.out.println("Enter Voter Name: ");
								vName = scan.next();
								System.out.println("Enter Voter Age: ");
								vAge = scan.nextInt();
								if(vAge < 18) {
									System.out.println("Voter age is below 18 years!");
								}
								else {
									System.out.println("Enter password : ");
									pass1 = scan.next();
									System.out.println("Re-enter password : ");
									pass2 = scan.next();
									if(pass1.equals(pass2) ) {
										if(pass1.length() >= 8) {
											Voter VOTER = new Voter(vName, vAge, pass1);
											voterList.add(VOTER);
											System.out.println("Voter registered!");
											System.out.println(VOTER);
											break;
										}
										else {
											System.out.println("Password should contain atleast 8 characters.");
										}
									}
									else {
										System.out.println("Password didn't match! ");
									}									
								}
							}while(true);
								break;
														
						case 2:
							System.out.println("Enter Nominee Name: ");
							vName = scan.next();
							System.out.println("Enter Desired position: ");
							nPos = scan.next();
							System.out.println("Enter Age: ");
							vAge = scan.nextInt();
							if(vAge > 20) {
								Nominee nominee = new Nominee(vName, nPos, vAge);
								nomList.add(nominee);
								System.out.println("Nominee added!");
								System.out.println(nominee);
							}
							else {
								System.out.println("Age should be above 20 years!");
							}
							
							break;	
							
						case 3:
							break;
				
					}
					System.out.println("");
					break;
			}
		}while(ch < 3);

	}

}
