package com.hs.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	static AtomicReference<Person> atomicReference = new AtomicReference<Person>(
			new Person(20));

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 3; i++) {
					atomicReference.set(new Person(
							atomicReference.get().age + 10));
					System.out.println("Atomic Check by first thread: "
							+ Thread.currentThread().getName() + " is "
							+ atomicReference.get().age);
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Person person = atomicReference.get();
				for (int i = 1; i <= 3; i++) {
					atomicReference.compareAndSet(person, new Person(
							atomicReference.get().age + 10));
					System.out.println("Atomic Check by second thread : "
							+ Thread.currentThread().getName() + " is "
							+ atomicReference.get().age);
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Final value: " + atomicReference.get().age);
	}
}