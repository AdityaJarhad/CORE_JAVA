package com.app.sorting;

import java.util.Comparator;

import com.app.core.Customer;

public class SortCustomer implements Comparator<Customer>
{
//	 Sort the accounts as per asc order of DoB of the bank customer n desc order of lastname
	@Override
	public int compare(Customer o1, Customer o2) {
		int retVal = o1.getDob().compareTo(o2.getDob());
		
		if(retVal == 0)
		{
			if(o1.getLastname().equals(o2.getLastname()))
				return 1;
			if(o1.getLastname().equals(o2.getLastname()))
				return 0;
		}
		return -1;
	}
	
	
}
