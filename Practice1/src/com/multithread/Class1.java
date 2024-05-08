package com.multithread;

public class Class1 extends Thread {

	public void run() {
		for (int i = 0; i < 120; i++) 
		{
			System.out.println("class1");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

