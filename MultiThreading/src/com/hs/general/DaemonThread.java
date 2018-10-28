package com.hs.general;

/*
 * and daemon threads are like normal(user) threads, but there is a big difference here. 
 * JVM kills(halt) the application when there is no user thread exist(alive), in other word if you have 1 user 
 * thread(main thread for example) and 1000 daemon threads. here JVM sees one thread in your application, 
 * and it kills the application just after that main thread finishes its job.
 * */
public class DaemonThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 10; i < 300; i++) {
					System.out.println("daemon thread prints " + i);
				}

			}
		});
		t1.setDaemon(true);

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("normal thread prints " + i);
				}

			}
		});
		t1.start();
		t2.start();

		System.out.println("main thread done");

	}
}
