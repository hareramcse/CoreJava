package com.hs.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
	private BlockingQueue<Runnable> queue;
	private List<PoolThread> threads;
	private boolean shutDownInitiated = false;

	public ThreadPool(int nThreads) {
		queue = new LinkedBlockingQueue<Runnable>(nThreads);
		threads = new ArrayList<PoolThread>();

		for (int i = 0; i < nThreads; i++) {
			threads.add(new PoolThread(queue));
			System.out.println("Thead-" + i + " created in Thread pool.");
		}

		for (PoolThread thread : threads) {
			thread.start();
		}
	}

	public synchronized void addTask(Runnable task) throws Exception {
		if (this.shutDownInitiated)
			throw new Exception("ThreadPool has been shutDown");
		queue.put(task);
		System.out.println("task has been added.");
	}

	public boolean isShutDownInitiated() {
		return shutDownInitiated;
	}

	public void shutDownInitiated() {
		System.out.println("ThreadPool shutdown initiated.");
		this.shutDownInitiated = true;
		for (PoolThread thread : threads) {
			thread.doStop();
		}
	}
}

class PoolThread extends Thread {

	private BlockingQueue<Runnable> queue;
	private boolean isStopped = false;

	public PoolThread(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (!isStopped()) {
				Runnable runnable = queue.take();
				runnable.run();
				System.out.println(Thread.currentThread().getName() + " has executed task.");
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " has been stopped.");
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		this.interrupt(); // break pool thread out of dequeue() call.
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CustomThreadPool {
	public static void main(String[] args) throws Exception {
		ThreadPool threadPool = new ThreadPool(3);
		Runnable task = new Task();
		threadPool.addTask(task);
		threadPool.addTask(task);
		threadPool.addTask(task);
		Thread.sleep(5000);
		threadPool.shutDownInitiated();
	}
}