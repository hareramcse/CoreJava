package com.hs.previouswork;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.add(12);
		pQueue.add(7);
		pQueue.add(9);
		pQueue.add(6);
		pQueue.add(4);
		pQueue.add(8);
		pQueue.add(14);
		pQueue.add(2);
		pQueue.add(56);
		pQueue.add(67);
		pQueue.add(1452);
		System.out.println("size of queue is " + pQueue.size());
		for(int i =0; i<= 10; i++)
		System.out.println(pQueue.poll());
	}
}
