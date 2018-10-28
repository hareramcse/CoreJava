package com.hs.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection {
	private static Connection instance = new Connection();
	private int connections = 0;

	private Semaphore semaphore = new Semaphore(7);

	private Connection() {

	}

	public static Connection getConnection() {
		return instance;
	}

	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			doConnect();
		} finally {
			semaphore.release();
		}
	}

	public void doConnect() {
		synchronized (this) {
			connections++;
			System.out.println("Current Connections " + connections);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// if we remove this then there will be 10 connection
		synchronized (this) {
			connections--;
		}
	}

	public void method1() {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
		}
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
		}
	}

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
		}
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
		}
	}

}

public class LimitNoOfObjectInPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Runnable() {
				public void run() {
					Connection.getConnection().connect();
				}
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
