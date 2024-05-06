package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.customerexception.CMSexception;

public class CMSUtils {

	public static Customer checkEmailAndPasswdToSignin(String email, String passwd, Map<Integer, Customer> custMap) throws CMSexception
	{		
		for(Customer c : custMap.values())
			if(c.getEmail().equals(email) && c.getPassword().equals(passwd))
				return c;
				
		throw new CMSexception("Invalid passwd, login failed");
	}
		
		
	public static void changePassword(String email, String passwd, String newPasswd, Map<Integer, Customer> clist) throws CMSexception
	{
		Customer customer = checkEmailAndPasswdToSignin(email,passwd,clist);
		customer.setPassword(newPasswd);
	}
	
//	Unsubscribe account
	@SuppressWarnings("unlikely-arg-type")
	public static Customer unSubscribe(String email, String passwd, Map<Integer, Customer> unlist) throws CMSexception
	{
		
		Customer c = checkEmailAndPasswdToSignin(email, passwd, unlist);
		
		return unlist.remove(c);
		
	}
	
	
	public static void removeAcntByDobPlan(String dob, String plan, Map<Integer, Customer> custMap) {
		
		System.out.println("In remove acnt by dob and plan");
	
		
		
		LocalDate ld = LocalDate.parse(dob);
		ServicePlan sp = ServicePlan.valueOf(plan.toUpperCase());
	
		List<Customer> custlist = new ArrayList<>(custMap.values());
		
		Iterator<Customer> itr = custlist.iterator();
		while(itr.hasNext())
		{
			Customer c2= itr.next();
			if(c2.getDob().isAfter(ld) && c2.getPlan() == sp)
			{
				 custMap.remove(c2.getUID());
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
	

}
