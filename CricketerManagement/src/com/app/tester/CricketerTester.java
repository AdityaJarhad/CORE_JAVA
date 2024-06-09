package com.app.tester;

import static com.app.utils.CricketerDetails.populateList;
import static com.app.utils.CricketerDetails.populateMap;
import static com.app.utils.Validations.changeRating;
import static com.app.utils.Validations.searchByName;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Cricketers;

public class CricketerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			List<Cricketers> list = populateList();
			Map<String, Cricketers> map = populateMap(list);
			Cricketers cricketers;
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("\nEnter\n"
							+ "1.Accept minimum 5 Cricketers in the collection.\n"
							+ "2.Modify Cricketer's rating\n"
							+ "3.Search Cricketer by name\n"
							+ "4.Display all Cricketers added in collection\n"
							+ "5.Display All Cricketers in sorted form by rating\n"
							+ "0.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter name, age, email_id, Phone, rating");
						cricketers = new Cricketers(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
						System.out.println(map.put(cricketers.getEmail(), cricketers));
						break;
					case 2:
						System.out.println("Enter email and rating");
						System.out.println(changeRating(sc.next(), sc.nextInt(), map));
						break;
					case 3:
						//3.Search Cricketer by name
						System.out.println("Search Cricketer by name");
						searchByName(sc.next(),map);
						break;
					case 4:
						map.forEach((k, v) -> System.out.println(v));
						break;
					case 5:
						//5.Display All Cricketers in sorted form by rating
						map.values()
						.stream()
						.sorted((c1, c2) -> c1.getRating() - c2.getRating())
						.forEach(l -> System.out.println(l));
		
						break;
					default:
						exit=true;
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
