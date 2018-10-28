package com.hs.collection;

import java.util.HashMap;
import java.util.Map;

public class ThreadSafeIteratorExample {
	static int count = 0;

	public static void test() {

		Map<Integer, String> myMap = new HashMap<Integer, String>();

		for (int i = 0; i < 100; i++) {
			myMap.put(i, "a" + i);
			count++;
		}

		for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
			System.out.println("it is printed by "
					+ Thread.currentThread().getName() + " key is "
					+ entry.getKey() + ", and value is " + entry.getValue());
		}
		System.out.println("total no of count is " + count);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t3 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t4 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t5 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t6 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t7 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t8 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});

		Thread t10 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});
		Thread t9 = new Thread(new Runnable() {

			public void run() {
				test();
			}
		});
		t1.setName("first Thread");
		t1.start();

		t2.setName("second Thread");
		t2.start();

		t3.setName("third Thread");
		t3.start();

		t4.setName("fourth Thread");
		t4.start();

		t5.setName("fiveth Thread");
		t5.start();

		t6.setName("sixth Thread");
		t6.start();

		t7.setName("seventh Thread");
		t7.start();

		t8.setName("eighth Thread");
		t8.start();

		t9.setName("nineth Thread");
		t9.start();

		t10.setName("tenth Thread");
		t10.start();
	}
}