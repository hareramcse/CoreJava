package com.hs.availableprocessor;

public class FindAvailableProcessor {
	public static void main(String[] args) {
		int available=Runtime.getRuntime().availableProcessors();
		System.out.println(available);
	}
}
