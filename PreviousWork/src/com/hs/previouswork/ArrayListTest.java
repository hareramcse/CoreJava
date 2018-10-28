package com.hs.previouswork;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
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
		list.remove(10);
		System.out.println(list);
		/*
		 * deafult capacity of arraylist is 10. and when we insert the 11th element in the list then new capacity becomes 10*3/2 means 15.
		 * whenever we modify then modcount increases by 1
		 *
		 **/
	}
}
