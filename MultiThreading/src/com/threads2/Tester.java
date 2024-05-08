package com.threads2;

public class Tester {
	public static void main(String[] args) throws InterruptedException {
		//display name of the thread
		System.out.println(Thread.currentThread()); //toString -- Thread(main, 5, main)
		
		//create mulltiple child threads (implements Thread)
		//create multiple task instance(i.e. implementation class of Runnable
		MyClass runnableTask = new MyClass();
		//Thread(Runnable instance, String name)
		Thread t1 = new Thread(runnableTask, " one ");
		Thread t2 = new Thread(runnableTask, " two ");
		Thread t3 = new Thread(runnableTask, " three ");
		Thread t4 = new Thread(runnableTask, " four ");
		//How many runnable threads ? 1
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//How many runnable threads ? 1(main) + 6(child)
		System.out.println(t1.isAlive()+" "+t4.isAlive());// t t
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " Execution count : " + i);
			Thread.sleep(500);
		}
		System.out.println(t1.isAlive()+" "+t4.isAlive());// f f
		System.out.println("Main over");
	}
}
