package com.hs.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyThirdStream {
	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("A");
		name.add("AAA");
		name.add("AAAA");
		name.add("AA");
		name.add("AAAAA");

		Comparator<String> c = (s1, s2) -> {
			int l1 = s1.length();
			int l2 = s2.length();
			return (l1 < l2) ? -1 : (l1 > l2) ? 1 : s1.compareTo(s2);
		};
		List<String> sortByLength = name.stream().sorted(c).collect(Collectors.toList());
		System.out.println(sortByLength);
	}
}
