package com.hs.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CustomLRU<K, V> {

	private List<K> list = new LinkedList<K>();
	private Map<K, V> map = new HashMap<K, V>();
	int maxSize = 0;

	public CustomLRU(final int MAX_SIZE) {
		this.maxSize = MAX_SIZE;
	}

	public V addElement(K key, V value) {
		try {
			// existing cache
			if (map.containsKey(key)) {
				list.remove(key);
			}
			// out of capacity
			while (list.size() >= maxSize) {
				K queueKey = list.remove(0);
				map.remove(queueKey);
			}
			// new cache
			list.add(key);
			map.put(key, value);

			return value;
		} finally {
		}
	}

	public V getElement(K key) {
		try {
			V value = null;
			if (map.containsKey(key)) {
				// first remove it because it is now recently used cache so it
				// should be in top of list so we need to add again after removing from queue.
				list.remove(key);
				value = map.get(key);
				list.add(key);
			}
			return value;
		} finally {
		}
	}

	public V removeElement(K key) {
		try {
			V value = null;
			if (map.containsKey(key)) {
				value = map.remove(key);
				list.remove(key);
			}
			return value;
		} finally {
		}
	}

	// need to analyze
	public static void main(String[] args) {
		CustomLRU<Integer, String> clc = new CustomLRU<Integer, String>(3);
		clc.addElement(1, "One");
		clc.addElement(2, "Two");
		clc.addElement(3, "Three");
		for (Entry<Integer, String> e : clc.map.entrySet()) {
			System.out.print(e.getKey() + "=" + e.getValue() + " ");
		}
		System.out.println();
		clc.getElement(1);
		for (Entry<Integer, String> e : clc.map.entrySet()) {
			System.out.print(e.getKey() + "=" + e.getValue() + " ");
		}
		System.out.println();
		clc.getElement(2);

		clc.addElement(4, "four");
		clc.addElement(5, "five");

		for (Entry<Integer, String> e : clc.map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}