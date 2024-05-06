package com.app.tester;

import static com.app.utils.Details.details;
import static com.app.utils.CMSUtils.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;
import com.app.sorting.SortCustomer;
import com.app.utils.CMSUtils;
import com.app.utils.CMSValidations;

public class CMSApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			boolean exit = false;
			// init D.S
			Map<Integer, Customer> customerMap = details(); // size:0 cap:10
			
			
				while (!exit) {
					System.out.println(
							"\nEnter 1.Sign up \n2.Sign in \n3.Change password \n4.Un subscribe customer \n"
							+ "5.Display all customers \n6.Sort by dob\n7.Sort by DOB and desc balance\n"
							+ "8.Remove accnt based on date and plan\n0.Exit ");
					System.out.println("Choose");
					LinkedList<Customer> customerList = new LinkedList<Customer>(customerMap.values());
					try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter :- firstname, lastname, email, password, registrationAmount, birth date, ServicePlan ");
						Customer customer = CMSValidations.validateCustomerInputs(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), sc.next(), sc.next(), customerMap);
						customerMap.put(customer.getUID(),customer);
						System.out.println("Account created ...");
						break;

					case 2:
						System.out.println("Enter Your email & password");
						Customer customer2 = CMSUtils.checkEmailAndPasswdToSignin(sc.next(),sc.next(), customerMap);
						System.out.println("Succesful login \nUser Details : "+customer2);

						break;

					case 3:
						System.out.println("Enter email, passwd & new Passwd");
						CMSUtils.changePassword(sc.next(),sc.next(),sc.next(), customerMap);
						System.out.println("Passwd changed successfuly");

						break;

					case 4:
						System.out.println("Enter Your email and passwd to confirm Un-subscribe account");
						customer = CMSUtils.unSubscribe(sc.next(), sc.next(), customerMap);
						System.out.println("Below removed successfully\n"+customer);

						break;

					case 5:
						System.out.println("Your details : \n");
						for(Customer i : customerMap.values())
							System.out.println(i);
						break;
						
					case 6:
						System.out.println("Natural ordering by dob");

						Collections.sort(customerList, new SortCustomer());
						for (Customer a: customerList) {
							System.out.println(a);
						}
						System.out.println("Sorting successful");
						
						break;
						
					case 7:
						System.out.println("Sorting details by DOB and lastname");
						Collections.sort(customerList, new SortCustomer());
						for(Customer c : customerList)
							System.out.println(c);
						
						break;
						
					case 8:
						System.out.println("Enter date and plan to remove acnt");
						removeAcntByDobPlan(sc.next(), sc.next(), customerMap);
						
						break;
						
					case 9:
						
						break;

					default:
						exit = true;
						break;
					}
					} catch (Exception e) {
						sc.nextLine();
						e.printStackTrace();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
