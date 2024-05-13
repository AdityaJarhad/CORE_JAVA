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
//			1. Get all candidates
//			2. Increment candidate's votes(by candidate id)
//			3. Get to 2 candidates by votes
//			4. Get party name n total votes(group by)

			boolean exit = true;
			while (exit) {
				System.out.println("Enter\n" + "1. Get all candidates\r\n"
						+ "2. Login"
						+ "2. Increment candidate's votes(by candidate id)\r\n" 
						+ "3. Get to 2 candidates by votes\r\n"
						+ "4. Get party name n total votes(group by)\n" 
						+ "0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						list = dao.displayCandidates();
						list.forEach(System.out::println);

						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

						break;

					default:

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
