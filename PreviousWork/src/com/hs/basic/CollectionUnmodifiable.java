package com.hs.previouswork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUnmodifiable {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		List<String> l = Collections.unmodifiableList(list);
		// we cant modify the final list
		// Exception in thread "main" java.lang.UnsupportedOperationException
		l.set(1, "hello");
		System.out.println(l);
		
	}
}
