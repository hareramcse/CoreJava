package com.hs.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
	private int balance = 10000;

	private void deposit(int amount) {
		balance += amount;
	}

	private void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account a1, Account a2, int amount) {
		a1.withdraw(amount);
		a2.deposit(amount);
	}
}

class Runner {

	private Account account1 = new Account();
	private Account account2 = new Account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	/*
	 * private void accuireLock(Lock firstLock, Lock secondLock){ boolean
	 * gotFirstLock=false; boolean gotSecondLock=false;
	 * 
	 * while(true){ try{ gotFirstLock=firstLock.tryLock();
	 * gotSecondLock=secondLock.tryLock(); }finally{ if(gotFirstLock &&
	 * gotFirstLock){ return; } if(gotFirstLock){ firstLock.unlock();
	 * }if(gotSecondLock){ secondLock.unlock(); } } try { Thread.sleep(1); } catch
	 * (InterruptedException e) { e.printStackTrace(); } } }
	 */

	public void firstThread() {
		Random random = new Random();
		try {
			// The lock() method locks the Lock instance so that all threads
			// calling lock() are blocked until unlock() is executed.
			lock1.lock();
			lock2.lock();
			for (int i = 0; i < 5; i++) {
				Account.transfer(account1, account2, random.nextInt(100));
				try {
					System.out.println("First Thread is going to sleep for 1s");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			System.out.println("calling fianlly block");
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void secondThread() {
		Random random = new Random();
		try {
			System.out.println("calling second thread");
			lock2.lock();
			lock1.lock();
			System.out.println("after lock");
			for (int i = 0; i < 5; i++) {
				Account.transfer(account2, account1, random.nextInt(100));
				try {
					System.out.println("Second Thread is going to sleep for 1s");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock2.unlock();
			lock1.unlock();
		}
	}

	public void finished() {
		System.out.println("Account1 balance is " + account1.getBalance());
		System.out.println("Account2 balance is " + account2.getBalance());
		System.out.println("total balance is " + (account1.getBalance() + account2.getBalance()));
	}
}

public class MoneyTransferTest {
	public static void main(String[] args) {
		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				runner.secondThread();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		runner.finished();
	}
}
