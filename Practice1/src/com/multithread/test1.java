package com.multithread;

public class test1 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
				
		Class1 c1 = new Class1();
		Class2 c2 = new Class2();
		
		
		c1.start();
		System.out.println(c1.isAlive());
		c2.start();
	}
}