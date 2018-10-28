package com.hs.printseries;

public class EvenOddWithoutBlocking extends Thread {
	private static int i = 1;

	public void run() {
		while (i < 10) {
			if (i % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
				System.out.println("Even Threads print " + i);
				i++;
			}
			if (i % 2 == 1 && Thread.currentThread().getName().equals("Odd")) {
				System.out.println("Odd threads print " + i);
				i++;
			}
		}
	}

	public static void main(String[] args) {
		EvenOddWithoutBlocking eowb1 = new EvenOddWithoutBlocking();
		EvenOddWithoutBlocking eowb2 = new EvenOddWithoutBlocking();
		eowb1.setName("Even");
		eowb2.setName("Odd");
		eowb1.start();
		eowb2.start();
	}
}
