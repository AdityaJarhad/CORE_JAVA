package com.app.sorting;

import java.util.Comparator;

import com.app.core.Customer;

public class SortCustomer implements Comparator<Customer>
{
//	 Sort the accounts as per asc order of DoB of the bank customer n desc order of lastname
	@Override
	public int compare(Customer o1, Customer o2) {
	
		return -1*o2.getDob().compareTo(o1.getDob());
	}
	
	
}
