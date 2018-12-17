package com.hs.lock;

public class TicketBookingDriverProgram {
	public static void main(String[] args) {
		CustomLock customLock = new CustomReentrantLock();
		TicketBookingIRCTC myRunnable = new TicketBookingIRCTC(customLock, 3);
		new Thread(myRunnable, "Passanger-1 Nikhil").start();
		new Thread(myRunnable, "Passanger-2 Ranjan").start();
		new Thread(myRunnable, "Passanger-3 Yunnus").start();
		new Thread(myRunnable, "Passanger-4 CKM").start();
		new Thread(myRunnable, "Passanger-5 Ritz").start();
	}
}

class TicketBookingIRCTC implements Runnable {

	int ticketsAvailable; // scarce resource
	CustomLock customLock;

	public TicketBookingIRCTC(CustomLock customLock, int totalTicket) {
		this.customLock = customLock;
		ticketsAvailable = totalTicket;
	}

	public void run() {

		System.out.println("Waiting to book ticket : " + Thread.currentThread().getName());
		/* get hold of lock for booking ticket */
		customLock.lock();

		if (ticketsAvailable > 0) {
			System.out.println("Ticket booking started  for : " + Thread.currentThread().getName());

			// Ticket booking time is 2 sec, so sleep for 2sec
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			/* Update available ticket count */
			ticketsAvailable--;
			System.out.println(
					"Congratulation!!, Ticket BOOKED " + "successfully for : " + Thread.currentThread().getName());
			System.out.println("currently ticketsAvailable = " + ticketsAvailable);
		} else {
			ticketsAvailable--;
			System.out.println("Sorry!! Ticket NOT BOOKED for : " + Thread.currentThread().getName()
					+ ". Current booking status is Waiting list(W/L): " + Math.abs(ticketsAvailable));
		}
		customLock.unlock();
	}
}
