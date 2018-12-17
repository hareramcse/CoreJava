package com.hs.printseries;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSeriesByAtomicInteger {

	private AtomicInteger sharedOutput = new AtomicInteger(0);

	private class ThreadTasks implements Runnable {

		private final int threadPosition;

		public ThreadTasks(int threadPosition) {
			this.threadPosition = threadPosition;
		}

		@Override
		public void run() {
			while (sharedOutput.get() < 10) {
				if (sharedOutput.get() % 4 == this.threadPosition) {
					int value = sharedOutput.get() + 1;
					System.out.println("Printing output for Thread: "
							+ this.threadPosition + "  " + value);
					sharedOutput.incrementAndGet();
				}
			}
		}
	}

	public static void main(String args[]) {

		PrintSeriesByAtomicInteger t = new PrintSeriesByAtomicInteger();

		ThreadTasks t1 = t.new ThreadTasks(0);
		ThreadTasks t2 = t.new ThreadTasks(1);
		ThreadTasks t3 = t.new ThreadTasks(2);
		ThreadTasks t4 = t.new ThreadTasks(3);

		Thread ts1 = new Thread(t1);
		Thread ts2 = new Thread(t2);
		Thread ts3 = new Thread(t3);
		Thread ts4 = new Thread(t4);
		ts1.start();
		ts2.start();
		ts3.start();
		ts4.start();
	}

}