package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import javax.naming.BinaryRefAddr;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.customerexception.CMSexception;
//4. validation rules

public class CMSValidations {
//	4.1 no dup customers (2 customers can't have the same email id)
//(i.e if the customer tries to register using existing email , raise custom exception)
	public static void checkForDupCustomer(String email, List<Customer> customerList) throws CMSexception
	{
		// create customer class instance wrapping PK	
		Customer c1 = new Customer(email);
		for (Customer a : customerList) {
			if (a.getEmail().equals(c1.getEmail()))
				throw new CMSexception("Duplicate email found! Use another mail id ...");
		}
	}
	
//	4.2 Validate plan
//	plan must be of supported types
	
	public static ServicePlan parseAndValidatePlanAndCharges(String plan, double regAmount) throws CMSexception
	{
		// pasrsing plan string to ServicePlan enum
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
//	4.3 reg amount must match with the plan
		// chk plan is equal to given registration amount
		
		if(servicePlan.getPlanCost() == regAmount)
		{
			return servicePlan;
		}
		
		throw new CMSexception("Please enter valid plan value ");
		
	}
	
//	to sign in check email and password
	public static Customer checkEmailAndPasswdToSignin(String email, String password, List<Customer> customerList) throws CMSexception
	{
		//chk email and passwd
		Customer c = new Customer(email,password);
		for(Customer c1: customerList)
		{
		if(c.getEmail().equals(c1.getEmail()) && c.getPassword().equals(c1.getPassword()))
		{
			System.out.println("Successfully Logged in ...");
			return new Customer(email,password);
			
		}
		}
		throw new CMSexception("UserId or Password is wrong!");
	}
	
	
//	add methods to validate customer all details
	public static Customer validateCustomerInputs(String firstname, String lastname, String email, String password, double registrationAmount,
			String dob, String plan, List<Customer> customers) throws CMSexception
	{
//		chk email exception for list of Customers	
		checkForDupCustomer(email,customers);
		
//		validate servicePlan 
		ServicePlan servicePlan = parseAndValidatePlanAndCharges(plan, registrationAmount);
		
//		parse birthdate
		LocalDate birthDate = LocalDate.parse(dob);

		return new Customer(firstname, lastname, email, password, registrationAmount, birthDate, servicePlan);
		
	}
	
//	4.4 email must contain @ and it should end with either
//	.com | .org | .net

	
	
	
//	4.5 password must be alphanumeric 
//	Hint : Use regular expression here.
//	regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})"
	
	
	
	
	
	
	
	
	
	
	
	
	
}
