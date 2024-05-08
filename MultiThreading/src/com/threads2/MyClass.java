package com.threads2;

public class MyClass implements Runnable {
	
	// mandatory to implemnt runnable ? No
	@Override
	public void run() /* throws InterruptedException */
	{
		System.out.println(Thread.currentThread().getName() + "Started");
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "Execution count : " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+" got exc "+e);
		}
		System.out.println(Thread.currentThread().getName() + "Over");
	}
}
