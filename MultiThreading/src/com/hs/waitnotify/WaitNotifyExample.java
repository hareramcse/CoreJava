package com.hs.waitnotify;

import java.util.Scanner;

class Processor {
	public void produce() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " running...");
		synchronized (this) {
			wait();
			System.out.println("resumed...");
		}
	}

	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Thread.currentThread().getName() + " running");
		synchronized (this) {
			System.out.println("waiting for the return key...");
			scanner.nextLine();
			System.out.println("returnk key pressed...");
			notify();
			Thread.sleep(5000);
			System.out.println("after notify of consume method");
		}
		scanner.close();
	}
}

public class WaitNotifyExample {
	public static void main(String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.setName("Producer Thread");
		t2.setName("Consumer Thread");
		t1.start();
		t2.start();

	}
}
