package com.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {
	public static void main(String[] args) {
		// 
		try(Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new FileReader("file"));
				PrintWriter pw = new PrintWriter(new FileWriter("file1")))
		{
			
			br.lines().forEach(l -> pw.println(l));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End of main");
		
		
	}
}
