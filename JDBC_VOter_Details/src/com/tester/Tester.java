package com.tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.entities.User;
import com.daointerface.DAOImpl;

public class Tester {
	public static void main(String[] args) throws SQLException {
		DAOImpl dao = new DAOImpl();

		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			while (!exit) {
				System.out.println("Enter \n"
						+ "1. Display voter's details\n" 	
						+ "2. Sign in\n"
						+ "3. Update voter's password\n"
						+ "4. Delete voter\n"
						+ "5. Add user\n" 
						+ "0. Exit");
				int value = sc.nextInt();
				try {
					switch (value) {
					case 1:
						List<User> list = dao.displyDetails();
						list.forEach(System.out::println);
						break;

					case 2:
						System.out.println("Enter email, passwd");
						User s = dao.signIn(sc.next(), sc.next());
						System.out.println(s);
						break;
						
					case 3:
						System.out.println("Enter email, passwd and new passwd");
						String s1 = dao.updatePasswd(sc.next(), sc.next(), sc.next());
						System.out.println(s1);
						break;
						
					case 4:
						System.out.println("enter email and password");
						String s2 = dao.deleteVoter(sc.next(),sc.next());
						System.out.println("User deleted succefully\nDetails\n"+s2);
						break;
						
					case 5:
						System.out.println("Enter first_name, last_name, email, password, dob");
						User user = new User(sc.next(),sc.next(),sc.next(),sc.next(),Date.valueOf(sc.next()));
						System.out.println("User added successfully - \n"+dao.addUser(user));
						break;

					default:
						dao.close();
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
