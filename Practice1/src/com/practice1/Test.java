package com.practice1;

import java.security.Provider.Service;

public class Test {
	public static void main(String[] args) {
		String plan = "GOLD";
		double amt = 2000;
		ServicePlan sp = ServicePlan.valueOf(plan);
		if(sp.getPlanCost() == amt)
		{
			System.out.println("success");
		}
	}
}
