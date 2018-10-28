package com.hs.printseries;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadStartAtATime {
	public static void main(String[] args) {
		CyclicBarrier gate = new CyclicBarrier(3);

		Thread t1 = new Thread() {
			public void run() {
				try {
					gate.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				try {
					gate.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		};
		System.out.println("Thread1 started at " + System.currentTimeMillis());
		t1.start();
		t2.start();
		System.out.println("Thread2 started at " + System.currentTimeMillis());

		// At this point, t1 and t2 are blocking on the gate.
		// Since we gave "3" as the argument, gate is not opened yet.
		// Now if we block on the gate from the main thread, it will open
		// and all threads will start to do stuff!

		try {
			gate.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("all threads started");
	}
}
