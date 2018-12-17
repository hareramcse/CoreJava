package com.hs.lock;

interface CustomLock {
	public void lock();

	public boolean tryLock();

	public void unlock();
}

public class CustomReentrantLock implements CustomLock {
	/* Maintain number of locks acquired by a thread */
	int lockHoldCount;

	/* Id of thread which is currently holding the lock. */
	long threadId;

	/**
	 * Creates an instance of CustomReentrantLock and Initial lock hold count is 0.
	 */
	CustomReentrantLock() {
		lockHoldCount = 0;
	}

	@Override
	public synchronized void lock() {
		/*
		 * Acquires the lock if it is not held by another thread and set lock hold count
		 * to 1.
		 */
		if (lockHoldCount == 0) {
			lockHoldCount++;
			threadId = Thread.currentThread().getId();
		}
		/*
		 * If current thread already holds lock then hold count is increased by 1 -
		 * Chain locking.
		 */
		else if (lockHoldCount > 0 && threadId == Thread.currentThread().getId()) {
			lockHoldCount++;
		}
		// If the lock is held by another thread then the current
		// thread waits for another thread to release lock.
		else {
			try {
				wait();
				lockHoldCount++;
				threadId = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void unlock() {
		/*
		 * If current thread is not holding the lock, if unlock is called it throws
		 * IllegalMonitorStateException.
		 */
		if (lockHoldCount == 0)
			throw new IllegalMonitorStateException();
		/* If lock is held, decrement lock hold count by 1 */
		lockHoldCount--;

		/*
		 * If lockHoldCount is 0, lock is released and waiting thread is notified.
		 */
		if (lockHoldCount == 0)
			notify();

	}

	@Override
	public synchronized boolean tryLock() {
		/*
		 * Acquires the lock if it is not held by another thread and // returns true
		 */
		if (lockHoldCount == 0) {
			lock();
			return true;
		}
		// If lock is held by another thread then method return false.
		else
			return false;
	}
}
