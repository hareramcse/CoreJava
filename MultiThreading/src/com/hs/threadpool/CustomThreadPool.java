package com.hs.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
	private BlockingQueue<Runnable> queue;

	private boolean shutDownInitiated = false;

	public ThreadPool(int nThreads) {
		queue = new LinkedBlockingQueue<Runnable>(nThreads);

		for (int i = 1; i <= nThreads; i++) {
			ThreadsPoolsThread threadPoolsThread = new ThreadsPoolsThread(
					queue, this);
			threadPoolsThread.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in Thread pool.");
			threadPoolsThread.start();
		}
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.shutDownInitiated)
			throw new Exception("ThreadPool has been shutDown");
		queue.put(task);
		System.out.println("task has been added.");
	}

	public boolean isPoolShutDownInitiated() {
		return shutDownInitiated;
	}

	public synchronized void shutdown() {
		this.shutDownInitiated = true;
		System.out.println("ThreadPool shutdown initiated.");
	}
}

class ThreadsPoolsThread extends Thread {

	private BlockingQueue<Runnable> queue;
	private ThreadPool threadPool;

	public ThreadsPoolsThread(BlockingQueue<Runnable> queue,
			ThreadPool threadPool) {
		this.queue = queue;
		this.threadPool = threadPool;
	}

	public void run() {
		try {
			while (true) {
				System.out.println(Thread.currentThread().getName()
						+ " is ready to execute task.");
				Runnable runnable = queue.take();
				System.out.println(Thread.currentThread().getName()
						+ " has taken task.");
				runnable.run();
				System.out.println(Thread.currentThread().getName()
						+ " has executed task.");

				if (this.threadPool.isPoolShutDownInitiated()
						&& this.queue.size() == 0) {
					this.interrupt();
					Thread.sleep(1);
				}
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()
					+ " has been stopped.");
		}
	}
}

class Task1 implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()
					+ " is executing task.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CustomThreadPool {
	public static void main(String[] args) throws Exception {
		ThreadPool threadPool = new ThreadPool(2);
		Runnable task = new Task1();
		threadPool.execute(task);
		threadPool.execute(task);
		threadPool.shutdown();
	}
}