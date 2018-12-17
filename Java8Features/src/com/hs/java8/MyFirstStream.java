package com.hs.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyFirstStream {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		List<Integer> l2 = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l2);
	}
}
