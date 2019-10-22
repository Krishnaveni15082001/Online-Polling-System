import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) {
		int ch, key = 0, toWork, vote, voterId, vAge, choice;
		String pass, pass1, pass2, vName, nPos;
		boolean flag = false, check = false;
		Scanner scan = new Scanner(System.in);
		List<Nominee> cmList = new ArrayList<Nominee>();
		List<Nominee> pmList = new ArrayList<Nominee>();
		List<Nominee> presiList = new ArrayList<Nominee>();
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
											System.out.println("To whom are you willing to cast your vote?\n1 . President\n2 . Prime Minister\n3 . Chief Minister");
											choice = scan.nextInt();
											System.out.println("Enter respective id : ");
											vote = scan.nextInt();
											switch(choice) {
												case 1:
													for(Nominee nom : presiList) {
														if(nom.getNomId() == vote) {
															voter1.setPresiVote(vote);
															System.out.println("Vote Casted!");
															flag = true;
														}
													}
													if(flag == false) {
														System.out.println("President Id invalid!");
														flag = true;
													}
													
													System.out.println();
													break;
													
												case 2:
													if(vote < (10000 + pmList.size()) && 10000 <= vote) {
														voter1.setPmVote(vote);
														System.out.println("Vote Casted!");
														flag = true;
													}
													else {
														System.out.println("Prime Minister Id invalid!");
														flag = true;
													}
													
													System.out.println();
													break;
													
												case 3:
													if(vote < (10000 + cmList.size()) && 10000 <= vote) {
														voter1.setCmVote(vote);
														System.out.println("Vote Casted!");
														flag = true;
													}
													else {
														System.out.println("Chief Minister Id invalid!");
														flag = true;
													}
													
													System.out.println();
													break;
												}
											
											if(flag == false) {
												System.out.println("Voter Id Invalid!");
											}
											
											System.out.println("");
											break;
											
										case 2:
											System.out.println("Nominee List for the following:\n1 . President\n2 . Prime Minister\n3 . Chief Minister");
											choice = scan.nextInt();
											switch(choice) {
											
												case 1:
													if(presiList.size() == 0) {	
														System.out.println("No nominees registered yet!");
													}
													else {
														System.out.println("Nominee List: ");
														for(Nominee nom:presiList) {
															System.out.println(nom);
														}
													}
													break;
												
												case 2:
													if(pmList.size() == 0) {														
														System.out.println("No nominees registered yet!");
													}
													else {
														System.out.println("Nominee List: ");
														for(Nominee nom:pmList) {
															System.out.println(nom);
														}
													}
													break;
													
												case 3:
													if(cmList.size() == 0) {														
														System.out.println("No nominees registered yet!");
													}
													else {
														System.out.println("Nominee List: ");
														for(Nominee nom:cmList) {
															System.out.println(nom);
														}
													}
													break;
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
					if(check == false) {
						System.out.println("Voter not registered!");
					}
					System.out.println("");
					break;
					}
					
					
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
							System.out.println("Available positions:\n1 . President\n2 . Prime Minister\n3 . Chief Minister");
							System.out.println("Enter Desired position: ");
							choice = scan.nextInt();
							System.out.println("Enter Age: ");
							vAge = scan.nextInt();
							if(vAge >= 35) {
								
								Nominee nominee = new Nominee();
								nominee.setNomName(vName);
								nominee.setNomAge(vAge);
								
								switch(choice) {
									case 1:
										nominee.setNomPosition("President");
										presiList.add(nominee);break;
									case 2:
										nominee.setNomPosition("Prime Minister");
										pmList.add(nominee);break;
									case 3:
										nominee.setNomPosition("Chief Minister");
										cmList.add(nominee);break;
								}
								
								
								System.out.println("Nominee added!");
								System.out.println(nominee);
							}
							
							else {
								System.out.println("Age should be above 35 years!");
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
