package com.hs.java8;

import java.util.function.Function;

public class MyFunction {
	public static void main(String[] args) {
		Function<Integer, Integer> function = i -> i * i;
		System.out.println(function.apply(4));
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Hareram"));
	}
}
