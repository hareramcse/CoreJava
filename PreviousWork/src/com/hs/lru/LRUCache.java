package com.hs.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<V, K> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;
	private static final int MAX_SIZE = 3;

	public LRUCache(int capacity, float loadFactor, boolean accessOrder) {
		super(capacity, loadFactor, accessOrder);
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > MAX_SIZE;
	}

	public static void main(String[] args) {
		Map<String, String> lruCache = new LRUCache<>(16, 0.75f, true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
	}

}
