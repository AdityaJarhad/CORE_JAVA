package com.app.bank;

import java.time.LocalDate;
import java.util.*;
import static com.app.bank.ValidationRules.*;

public class Tester {
	public static void main(String[] args)
	{
		try(Scanner sc = new Scanner(System.in))
		{
			boolean flag = false;
			int count = 0;
			System.out.println("Enter total acnt numbers : ");
			BankAccount[] bAcnt = new BankAccount[sc.nextInt()];
			
			while(!flag)
			{
				System.out.println("Enter 1. Open bank account\r\n"
						+ "2. Deposit\n"
						+ "3. Withdraw\n"
						+ "4. Funds transfer\n"
						+ "5. Display All accounts (for bank manager role)\n"
						+ "6. Close account\n"
						+ "0. Exit!");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("acntNo, firstName, lastName, Acnt type, dob, Acnt create_date, balance");
					bAcnt[count++] = ValidInput(sc.nextInt(), sc.next(), sc.next(), acntTypeEnum.valueOf(sc.next()), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble());
					
					break;
				case 2:
					
					break;
					
				default:
					flag = true;
					break;
				}
			}
		}
	}
}
