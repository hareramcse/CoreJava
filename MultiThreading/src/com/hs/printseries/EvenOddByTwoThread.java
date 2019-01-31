package com.hs.printseries;

public class EvenOddByTwoThread {
	private static Object lock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 1; i < 10; i = i + 2) {
					synchronized (lock) {
						System.out.print(" " + i);
						try {
							lock.notify();
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 2; i < 10; i = i + 2) {
					synchronized (lock) {
						System.out.print(" " + i);
						try {
							lock.notify();
							if (i == 10) {
								break;
							}
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		try {
			t1.start();
			t2.start();
			t2.join();
		} catch (Exception e) {
			System.out.println("exception occured");
		}
		System.out.println();
		System.out.println("Main Over");
	}
}