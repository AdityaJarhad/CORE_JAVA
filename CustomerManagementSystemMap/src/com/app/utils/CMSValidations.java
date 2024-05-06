package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.customerexception.CMSexception;
//4. validation rules

public class CMSValidations {
//	4.1 no dup customers (2 customers can't have the same email id)
//(i.e if the customer tries to register using existing email , raise custom exception)
	public static void checkForDupCustomer(String email, Map<Integer, Customer> customerMap) throws CMSexception
	{
		for(Customer c : customerMap.values())
			if (c.getEmail().equals(email))
				System.out.println(c);
			
		throw new CMSexception("Duplicate email found! Use another mail id ...");
			
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
	
	
//	add methods to validate customer all details
	public static Customer validateCustomerInputs(String firstname, String lastname, String email, String password, double registrationAmount,
			String dob, String plan, Map<Integer, Customer> customers) throws CMSexception
	{
//		email pattern chk
		validEmail(email);
		
//		passwd pattern chk
		passChk(password);
		
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
	
	public static void validEmail(String email) throws CMSexception
	{
		if(!email.matches("^.*@.*[.com|.org|.net]$"))	
			throw new CMSexception("Email pattern is wrong");
	}
	
//	4.5 password must be alphanumeric 
//	Hint : Use regular expression here.
//	regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})"
	
	public static void passChk(String passwd) throws CMSexception{
		
		if(!passwd.matches("(?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20}"))
				throw new CMSexception("Password pattern is wrong");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
