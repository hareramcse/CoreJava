package com.hs.basic;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(11);
		set.add(12);
		set.add(13);
		set.add(14);
		set.add(15);
		set.add(16);
		set.add(17);
		set.add(18);
		set.add(19);
		set.add(20);
		set.add(21);
		set.add(22);
		set.add(23);
		set.add(24);
		set.add(25);
		set.add(26);
		set.add(27);
		set.add(28);
		set.add(10);

		System.out.println(set);

		/*
		 * it internally calls Hashmap and its all behaviour is same as hashmap
		 * including default capacity, loadfactor, thresold value and even
		 * internally it has entry objects. we can say there is nothing
		 * difference between map and set except map is key value pair and set
		 * takes only objects.
		 */

	}
}
