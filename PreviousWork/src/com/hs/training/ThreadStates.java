package com.hs.training;

public class ThreadStates {
	public static void main(String[] args) {
		Thread.State states[] = Thread.State.values();
		for (Thread.State state : states) {
			System.out.println(state);
		}
	}
}
