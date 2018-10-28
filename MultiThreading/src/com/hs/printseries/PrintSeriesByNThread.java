package com.hs.printseries;

class Notifier implements Runnable {

	private Object monitor;
	private int i = 1;
	private static boolean first = true;
	private static boolean second = false;
	private static boolean third = false;

	public Notifier(Object obj) {
		this.monitor = obj;
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (monitor) {
					String Tname = Thread.currentThread().getName();
					if (first && Tname.equalsIgnoreCase("T1")) {
						print();
						first = false;
						second = true;
						monitor.notifyAll();
						monitor.wait();
					} else if (second && Tname.equalsIgnoreCase("T2")) {
						print();
						second = false;
						third = true;
						monitor.notifyAll();
						monitor.wait();
					} else if (third && Tname.equalsIgnoreCase("T3")) {
						print();
						third = false;
						first = true;
						monitor.notifyAll();
						monitor.wait();
					} else {
						monitor.wait();
					}
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void print() {
		System.out.println(Thread.currentThread().getName() + " - " + this.i++);
	}
}

public class PrintSeriesByNThread {
	public static void main(String[] args) throws InterruptedException {
		Object monitor = new Object();
		Notifier notifier = new Notifier(monitor);
		Thread thread1 = new Thread(notifier, "T1");
		Thread thread2 = new Thread(notifier, "T2");
		Thread thread3 = new Thread(notifier, "T3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}