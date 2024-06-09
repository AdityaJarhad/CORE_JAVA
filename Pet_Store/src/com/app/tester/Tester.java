package com.app.tester;

import static com.app.utils.Details.populateOrder;
import static com.app.utils.Details.populatePet;
import static com.app.utils.Utils.orderStatus;
import static com.app.utils.Utils.upadatePet;
import static com.app.utils.Utils.updateOrderStatus;
import static com.app.utils.Validations.logIn;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Status;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Pet pet = null;
			Order order = null;
			Map<Integer, Pet> petMap = populatePet();
			Map<Integer, Order> orderMap = populateOrder();
			boolean exit = false;
			
			while (!exit) {
				System.out.println("\nEnter\n" + "1. Login\r\n" + "2. Add new Pet (Admin only functionality)\r\n"
						+ "3. Update Pet details (Admin only functionality)\r\n" + "4. Display all available pets\r\n"
						+ "5. Order a Pet\r\n" + "6. Check order status by Order Id\r\n"
						+ "7. Update order status (Admin only functionality)\r\n" + "8. Show orders\n" + "0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						// 1. Login
						System.out.println("Enter id and password");
						logIn(sc.next(), sc.next());
						break;
					case 2:
						// 2. Add new Pet (Admin only functionality)
						System.out.println("Enter name, category, unitPrice, Status");
						pet = new Pet(sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextInt(),
								Status.valueOf(sc.next().toUpperCase()));
						petMap.put(pet.getPetId(), pet);
						System.out.println("Pet added successfully...");
						break;
					case 3:
						// 3. Update Pet details (Admin only functionality)
						System.out.println("Enter pet Id to update");
						int p = sc.nextInt();
						System.out.println("Enter new price and staus");
						upadatePet(p, sc.nextInt(), Status.valueOf(sc.next().toUpperCase()), petMap);
						break;
					case 4:
						// 4. Display all available pets
						petMap.forEach((k, v) -> System.out.println(v));
						break;
					case 5:
						// 5. Order a Pet
						System.out.println("Enter pet_id, qty and status");
						order = new Order(sc.nextInt(), sc.nextInt(), Status.valueOf(sc.next()));
						System.out.println("Order successfull");
						break;
					case 6:
						// 6. Check order status by Order Id
						System.out.println("Enter id");
						orderStatus(sc.nextInt(), orderMap);
						break;
					case 7:
						// 7. Update order status (Admin only functionality)
						System.out.println("Enter order_id and new status");
						updateOrderStatus(sc.nextInt(), Status.valueOf(sc.next().toUpperCase()), orderMap);
						break;
					case 8:
						// 8. Show orders
						orderMap.forEach((k, v) -> System.out.println(v));
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
