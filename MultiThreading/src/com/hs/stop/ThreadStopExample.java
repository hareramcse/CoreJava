package com.hs.stop;

import java.util.Scanner;

class Processor extends Thread {
	// volatile means it will check the value of data from main memory not from
	// cache memory
	private volatile boolean running = true;
	private int count = 0;

	public void run() {
		while (running) {
			System.out.println(count);
			try {
				Thread.sleep(1000);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}
}

public class ThreadStopExample {
	public static void main(String[] args) {
		Processor processor = new Processor();
		processor.start();
		Scanner scanner = new Scanner(System.in);
		System.out.println("press any key to stop the thread..");
		scanner.nextLine();
		scanner.close();
		processor.shutDown();
	}
}