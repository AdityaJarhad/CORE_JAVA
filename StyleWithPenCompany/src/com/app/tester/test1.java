package com.app.tester;

import static com.app.utils.PenDetails.populateList;

import java.util.List;
import java.util.Scanner;

import com.app.core.Pens;;

public class test1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println(
				"Enter choice : " 
				+ "1. All pens details" 
				+ "2. Add new Pen" 
				+ "3. Update stock of a Pen"
				+ "4. Set discount of 20% for all the pens which are not at all sold in last 3 months"
				+ "5. Remove Pens which are never sold once listed in 9 months" 
				+ "0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Pens Details");
						List<Pens> list = populateList();
						list.forEach(l -> System.out.println(l));
						break;
					case 2:
						System.out.println("Enter Brand, color, inkColor, material, stock, price");
						
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
