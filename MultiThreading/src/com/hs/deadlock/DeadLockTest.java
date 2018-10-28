package com.hs.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

class Shared {
	synchronized void test1(Shared s2) {
		System.out.println("thread 1 waiting for lock 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s2.test2(this);
		System.out.println("test1 end");
	}

	synchronized void test2(Shared s1) {
		System.out.println("thread 2 waiting for lock 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s1.test1(this);
		System.out.println("test2 end");
	}
}

class A extends Thread {
	Shared s1, s2;

	A(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		s1.test1(s2);
	}
}

class B extends Thread {
	Shared s1, s2;

	B(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		s2.test2(s1);
	}
}

public class DeadLockTest {
	public static void main(String[] args) {
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		A a = new A(s1, s2);
		B b = new B(s1, s2);
		a.start();
		b.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadMXBean tx = ManagementFactory.getThreadMXBean();
		long ids[] = tx.findDeadlockedThreads();
		if (ids != null) {
			System.out.println("deadlock threads are");
			ThreadInfo ti[] = tx.getThreadInfo(ids);
			for (int i = 0; i < ti.length; i++) {
				System.out.println(ti[i].getThreadName());
			}
		} else {
			System.out.println("no threads are under deadlock");
		}
		System.out.println(a.getState());
		System.out.println(b.getState());
	}
}