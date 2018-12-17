package com.hs.basic;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("a", 3);
		Object obj = map.put("a", 2);
		System.out.println(obj);
		
		/*map.put("c", 1);
		map.put("d", 1);
		map.put("e", 1);
		map.put("f", 1);
		map.put("g", 1);
		map.put("h", 1);
		map.put("i", 1);
		map.put("j", 1);
		map.put("k", 1);
		map.put("l", 1);
		map.put("m", 1);
		map.put("n", 1);
		map.put("o", 1);
		map.put("p", 1);
		map.put("q", 1);
		map.put("r", 1);
		map.put("s", 1);
		map.put("t", 1);
		System.out.println(map);*/
		//System.out.println(map.size());
		
		/* here default capacity is 16 and load factor is 0.75 and thresold =(capacity*loadfactor) that is 12 by default.
		 * so when we insert the 13th element in the map then it increases the capacity to 100% and becomes 32
		 * even if all the elements are getting stored in one bucket also, there will be rehashing.
		 * 
		 * 
		 */
	}
}
