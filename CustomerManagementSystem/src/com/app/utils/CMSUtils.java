package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.customerexception.CMSexception;

public class CMSUtils {

	public static Customer checkEmailAndPasswdToSignin(String email, String passwd, List<Customer> custList) throws CMSexception{
//		1. indexOf
//		serching --by PK --yes --contains | indexOf
//		contains : not useful retns boolean
		
//		A. public int indexOf(object o)
//		create customer instance --wrapping email		
		Customer c = new Customer(email);
		
//		2. invalid email : throw customer exc
		int index = custList.indexOf(c);
		
		if(index < 0)
			throw new CMSexception("Invalid email !!");
		
		Customer c1 = custList.get(index);
		
//		3. get -- Customer ref --chk pwd --invalid --throw custom exc
//		ret customer ref
		if(c1.getPassword().equals(passwd))
			return c1;
		
		throw new CMSexception("Invalid passwd, login failed");
	}
		
		
	public static void changePassword(String email, String passwd, String newPasswd, List<Customer> clist) throws CMSexception
	{
		Customer customer = checkEmailAndPasswdToSignin(email,passwd,clist);
		clist.get(clist.indexOf(customer)).setPassword(newPasswd);
	}
	
//	Unsubscribe account
	public static Customer unSubscribe(String email, String passwd, List<Customer> unlist) throws CMSexception
	{
		Customer c1 = new Customer(email,passwd);
		checkEmailAndPasswdToSignin(email, passwd, unlist);
		int index = unlist.indexOf(c1);
		if(index == -1)
			throw new CMSexception("Invalid details! Un-subscription failed");
		return unlist.remove(index);
	}
	
	
	public static void removeAcntByDobPlan(String dob, String plan, List<Customer> custlist) {
		
		System.out.println("In remove acnt by dob and plan");
		LocalDate ld = LocalDate.parse(dob);
		ServicePlan sp = ServicePlan.valueOf(plan.toUpperCase());
	
		Iterator<Customer> itr = custlist.iterator();
		while(itr.hasNext())
		{
			Customer c2= itr.next();
			if(c2.getDob().isAfter(ld) && c2.getPlan() == sp)
			{
				 itr.remove();
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
	

}
