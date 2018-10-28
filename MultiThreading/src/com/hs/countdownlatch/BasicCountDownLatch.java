package com.hs.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	CountDownLatch countDownLatch;

	public Processor(CountDownLatch latch) {
		this.countDownLatch = latch;
	}

	public void run() {
		System.out.println("Started...");
		try {
			System.out.println("waiting....");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}
}

public class BasicCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Processor(latch));
		}
		try {
			System.out.println("waiting to count down latch to 0");
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed.....");
	}
}
