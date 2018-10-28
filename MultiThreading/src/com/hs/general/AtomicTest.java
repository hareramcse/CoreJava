package com.hs.general;

import java.util.concurrent.atomic.AtomicInteger;

class Processor implements Runnable {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			processSomething(i);
			System.out.println(count.incrementAndGet());
		}
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class AtomicTest {
	public static void main(String[] args) {
		Processor p = new Processor();
		Thread t1 = new Thread(p);
		t1.start();
		Thread t2 = new Thread(p);
		t2.start();
	}
}