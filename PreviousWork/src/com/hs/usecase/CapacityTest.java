package com.hs.usecase;

import java.util.ArrayList;
import java.util.List;

public class CapacityTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		// it increases the capacity by 50% once it reaches the threshold value
	}
}
