package com.hs.training;

import java.util.LinkedList;
import java.util.List;

class ProducerWithJoin implements Runnable {
	private List<Integer> list;
	private int maxSize;

	public ProducerWithJoin(List<Integer> list, int maxSize) {
		this.list = list;
		this.maxSize = maxSize;
	}

	public void run() {
		for (int i = 0; i <= maxSize; i++) {
			if (list.size() == maxSize) {
				try {
					System.out.println("hello");
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				list.add(i);
			}
		}
	}
}

class ConsumerWithJoin implements Runnable {
	private List<Integer> list;

	public ConsumerWithJoin(List<Integer> list) {
		this.list = list;
	}

	public void run() {
		while (true) {
			if (list.size() == 0) {
				try {
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				list.remove(0);
			}
		}

	}
}

public class ProducerConsumerWithJoin {

	public static void main(String args[]) {

		List<Integer> buffer = new LinkedList<Integer>();
		int maxSize = 5;

		Thread producer1 = new Thread(new ProducerWithJoin(buffer, maxSize));
		producer1.setName("producer thread 1");

		Thread consumer1 = new Thread(new ConsumerWithJoin(buffer));
		consumer1.setName("consumer thread 1");

		producer1.start();
		consumer1.start();
	}
}