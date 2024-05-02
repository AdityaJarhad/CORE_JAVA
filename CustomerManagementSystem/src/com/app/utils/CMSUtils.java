package com.app.utils;

import java.util.List;

import com.app.core.Customer;
import com.customerexception.CMSexception;

public class CMSUtils {

	public static Customer checkEmailAndPasswdToSignin(String email, String passwd, List<Customer> custList) throws CMSexception{
//		1. indexOf
//		serching --by PK --yes --ci=ontains | indexOf
//		contains : not useful retns boolean
		
//		A. public int indexOf(object o)
//		create customer instance --wrapping email		
		Customer c = new Customer(email);
		
//		2. invalid email : throw customer exc
		int index = custList.indexOf(c);
		
		if(index == -1)
			throw new CMSexception("Invalid email !!");
		
		Customer c1 = custList.get(index);
		
//		3. get -- Customer ref --chk pwd --invalid --throw custom exc
//		ret customer ref
		if(c1.getPassword().equals(passwd))
			return c1;
		
		throw new CMSexception("Invalid passwd, login failed");
	}
		
//		if(custList.contains(c))
//		{
//			System.out.println("Email verified ");
//			int idx = custList.indexOf(c);
//			if(custList.get(idx).getPassword().equals(passwd))
//			{
//				System.out.println("Password verified");
//				return c;
//			}
//			throw new CMSexception("wrong password");
//			
//		}
//		throw new CMSexception("wrong email");
			
		
	public static void changePassword(String email, String passwd, String newPasswd, List<Customer> clist) throws CMSexception
	{
		Customer customer = checkEmailAndPasswdToSignin(email,passwd,clist);
		clist.get(clist.indexOf(customer)).setPassword(newPasswd);
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
	

}
