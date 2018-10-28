package com.hs.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection {
	private static Connection instance = new Connection();
	private int connections = 0;

	private Semaphore semaphore = new Semaphore(5);

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
		// if we remove this then there will be 20 connection
		synchronized (this) {
			connections--;
		}
	}
}

public class DBConnectionExample {
	public static void main(String[] args) {
		/*
		 * Semaphore semaphore=new Semaphore(10); try { semaphore.acquire(); //
		 * acquires the permits } catch (InterruptedException e) {
		 * e.printStackTrace(); } semaphore.release(); // release the permits
		 * System.out.println(semaphore.availablePermits());
		 */

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