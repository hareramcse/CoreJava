package com.java8;

import java.util.stream.IntStream;

// if we want to use lamda exp then there should be functional interface method on which only we can use lamda exp

public class LamdaExpression {

	public static void main(String[] args) {
		boolean b=isPrime(12);
		System.out.println(b);
	}
	public static boolean isPrime(int num) {
		return num > 1
				&& IntStream.range(2, num).noneMatch(index -> num % index == 0);
	}
}
