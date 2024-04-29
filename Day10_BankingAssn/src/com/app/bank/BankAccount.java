package com.app.bank;

import java.time.LocalDate;
import static com.app.bank.ValidationRules.*;

public class BankAccount {
	
	private int acntNo;
	private String firstName;
	private String lastName;
	private acntTypeEnum Atype;
	private LocalDate dob;
	private LocalDate create_date;
	private double balance;
	
	public BankAccount(int acntNo, String firstName, String lastName, acntTypeEnum Atype, LocalDate dob, LocalDate create_date, double balance ) 
	{
		this.acntNo=acntNo;
		this.firstName=firstName;
		this.lastName=lastName;
		this.Atype=Atype;
		this.dob=dob;
		this.create_date=create_date;
		this.balance=balance;
	}
	
	public void deposit(int amt)
	{
		balance += amt;
	}

	public void withdraw(int amt) throws Exception
	{
		//before withdraw check remaining balance
		ValidRules(balance);
		balance -= amt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
