package com.app.tester;

import static com.app.utils.PenDetails.populateList;

import java.util.List;
import java.util.Scanner;

import com.app.core.Brand;
import com.app.core.Material;
import com.app.core.Pens;
import com.app.utils.Utils;;

public class test1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Pens> list = populateList();
			boolean exit = true;
			while (exit) {
				System.out.println("Enter choice : \n" + "1. All pens details\n" + "2. Add new Pen\n"
						+ "3. Update stock of a Pen\n"
						+ "4. Set discount of 20% for all the pens which are not at all sold in last 3 months\n"
						+ "5. Remove Pens which are never sold once listed in 9 months\n" + "0. Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Pens Details");
						list.forEach(l -> System.out.println(l));
						break;
					case 2:
						System.out.println("Enter Brand, color, inkColor, material, stock, price");
						Pens pens = new Pens(Brand.valueOf(sc.next().toUpperCase()), sc.next(), sc.next(),
								Material.valueOf(sc.next().toUpperCase()), 1200, 20);
						list.add(pens);
						System.out.println("User added succesfully\n" + pens);
						break;
					case 3:
						System.out.println("Enter id whose stock gonna you update");
						int stock = sc.nextInt();
						System.out.println(new Pens(stock));
						break;
					case 4:
						String msg = Utils.setDiscount(list);
						System.out.println(msg);
						break;
					case 5:
						System.out.println(Utils.removePens(list));
						break;
					default:
						exit = false;
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
