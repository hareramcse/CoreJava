package com.hs.java8;

import java.util.Random;

public class SameRandomNumber {
	Random randnum;

	public SameRandomNumber() {
        randnum = new Random();
        randnum.setSeed(123456789);
    }

	public int random(int i) {
		return randnum.nextInt(i);
	}
	
	public static void main(String[] args) {
		SameRandomNumber r= new SameRandomNumber();
		System.out.println(r.random(10));
	}
}