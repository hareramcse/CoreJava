package com.hs.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparator {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(4);
		list.add(21);
		list.add(18);
		list.add(17);

		Comparator<Integer> comparator = (I1, I2) -> (I1 < I2) ? -1 : (I1 > I2) ? 1 : 0;
		Collections.sort(list, comparator);
		System.out.println(list);

	}
}
