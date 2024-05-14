package com.tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Candidate;
import com.daoutility.DAOImplementation;

public class CandidateVotingTester {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			DAOImplementation dao = new DAOImplementation();
			List<Candidate> list = new ArrayList<>();

			boolean exit = true;
			while (exit) {
				System.out.println("Enter\n"
						+ "1. Get all candidates\r\n"
						+ "2. Please vote to candidate\r\n"
						+ "3. Get top 2 candidates by votes\r\n"
						+ "4. Get party name n total votes(group by)\n"
						+ "0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						list = dao.displayCandidates();
						list.forEach(System.out::println);

						break;
					case 2:
//						2. Increment candidate's votes(by candidate id)
						System.out.println("Enter \n1. BJP \n2. NCP \n3. Congress \n4. SP \n5. AAP");
						System.out.println(dao.pleaseVote(sc.nextInt()));
						
						break;
					case 3:
						list=dao.twoWinner();
						list.forEach(System.out::println);
						break;
					case 4:
						list = dao.partyNvotes();
						list.forEach(s->System.out.println("Party: "+s.getParty()+" Votes: "+s.getVotes()));
						break;

					default:
						dao.clean();
						exit=false;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
