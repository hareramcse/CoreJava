package com.hs.usecase;

import java.util.Scanner;

class Processor1 extends Thread {
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

public class StopThread {
	public static void main(String[] args) {
		Processor1 processor = new Processor1();
		processor.start();
		Scanner scanner = new Scanner(System.in);
		System.out.println("press any key to stop the thread..");
		scanner.nextLine();
		scanner.close();
		processor.shutDown();
	}
}
