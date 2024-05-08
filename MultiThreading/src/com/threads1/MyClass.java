package com.threads1;

public class MyClass extends Thread {
	public MyClass(String name) {
		super(name);
	}

	// mandatory to override thread
	@Override
	public void run() /* throws InterruptedException */
	{
		System.out.println(getName() + "Started");
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + "Execution count : " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(getName()+" got exc "+e);
		}
		System.out.println(getName() + "Over");
	}
}
