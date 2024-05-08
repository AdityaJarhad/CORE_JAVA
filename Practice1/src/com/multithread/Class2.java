package com.multithread;

public class Class2 extends Thread {

	public void run() {
		for (int i = 0; i < 120; i++) {
			System.out.println("adi");

			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
