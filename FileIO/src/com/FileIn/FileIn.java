package com.FileIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class FileIn {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name to read");
			//FILE READING : 			 <- FR <- BR <- Bin file
			
			BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
			br.lines().forEach(s -> System.out.println(s));
			
//			FileReader fr = new FileReader(sc.nextLine());
//			System.out.println(fr.read());	// Not working
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
