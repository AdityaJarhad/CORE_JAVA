package com.FileO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Write {

	public static void main(String[] args) {
		
		System.out.println("Enter file name to write");
		try (Scanner sc = new Scanner(System.in); 
				BufferedWriter bw = new BufferedWriter(new FileWriter(sc.nextLine()));

		) {
			// FILE READING : <- FR <- BR <- Bin file

			bw.write(sc.nextLine());

//			FileReader fr = new FileReader(sc.nextLine());
//			System.out.println(fr.read());	// Not working

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
