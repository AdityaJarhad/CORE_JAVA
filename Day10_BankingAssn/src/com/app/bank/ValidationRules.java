package com.app.bank;
import java.time.LocalDate;

import com.app.bank.*;

public class ValidationRules {
	
	public static double MIN_BALANCE;
	
	static
	{
		double MIN_BALANCE = 5000;
	}

	public static void ValidRules(double balance) throws BankingException
	{
		
		if(MIN_BALANCE < balance)
		{
			throw new BankingException("Your balance is insufficient!!! ");
		}
		else
			System.out.println("Sufficient balance...");
	}
	
	public static BankAccount ValidInput(int acntNo, String firstName, String lastName, acntTypeEnum Atype, 
			LocalDate dob, LocalDate create_date, double balance)
	{
		return new BankAccount(acntNo, firstName, lastName, Atype, dob, create_date, balance);
	}
	
}
