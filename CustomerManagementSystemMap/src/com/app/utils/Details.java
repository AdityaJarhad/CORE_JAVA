package com.app.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;

public class Details {
//	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000)
	public static Map<Integer ,Customer> details() {
		Customer c1 = new Customer("a1", "z1", "mail1", "pass1", 2000, LocalDate.parse("2006-01-01"), ServicePlan.GOLD);
		Customer c2 = new Customer("a2", "z2", "mail2", "pass2", 1000, LocalDate.parse("2000-01-01"), ServicePlan.SILVER);
		Customer c3 = new Customer("a3", "z3", "mail3", "pass3", 5000, LocalDate.parse("2003-01-01"), ServicePlan.DIAMOND);
		Customer c4 = new Customer("a4", "z5", "mail4", "pass4", 10000, LocalDate.parse("2008-01-01"), ServicePlan.PLATINUM);
		Customer c5 = new Customer("a5", "z5", "mail5", "pass5", 2000, LocalDate.parse("2004-01-01"), ServicePlan.GOLD);
		Customer c6 = new Customer("a6", "z5", "mail5", "pass5", 2000, LocalDate.parse("2001-01-01"), ServicePlan.GOLD);
		
		Customer[] cust = {c1, c2, c3, c4, c5, c6};
	
		Map<Integer, Customer> map = new HashMap<>();
		
		for(Customer i : cust)
			System.out.println(map.put(i.getUID(), i));
		
		return map;
	}
}
