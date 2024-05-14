package com.tester;

import java.util.Scanner;

import com.daoutilityvoters.DAOImplVoters;

public class votingTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			DAOImplVoters dao = new DAOImplVoters();
			
			boolean exit = false;
			while (!exit) {
				System.out.println("Enter 1. for voting \n"
						+ "0. Exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("You have to sign in for voting and vote compulsory");
					if(dao.signIn(sc.next(),sc.next())) {
						CandidateVotingTester.main(null);
					}
					else
						System.out.println("Invalid email and password");
					break;

				default:
					break;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
