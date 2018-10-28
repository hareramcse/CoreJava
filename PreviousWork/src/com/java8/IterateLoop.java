package com.java8;

import java.util.ArrayList;
import java.util.List;

public class IterateLoop {
	static List<Integer> integers = null;

	public static void main(String[] args) {
		integers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			integers.add(i);
		}
		traverseEach(integers);
	}

	private static void traverseEach(List<Integer> integers) {
		integers.forEach(value -> System.out.println("a" + value));
	}
}
