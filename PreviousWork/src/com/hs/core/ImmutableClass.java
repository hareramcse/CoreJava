package com.hs.core;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClass {

	private final int id;

	private final String name;

	private final HashMap<String, String> testMap;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		// return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 * 
	 * @param i
	 * @param n
	 * @param hm
	 */

	public ImmutableClass(int i, String string, HashMap<String, String> map) {
		System.out.println("Performing Deep Copy for Object initialization");
		this.id = i;
		this.name = string;
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String key;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			tempMap.put(key, map.get(key));
		}
		this.testMap = tempMap;
	}

	/**
	 * Constructor performing Shallow Copy
	 * 
	 * @param i
	 * @param n
	 * @param hm
	 */
	/**
	 * public FinalClassExample(int i, String n, HashMap<String,String> hm){
	 * System.out.println("Performing Shallow Copy for Object initialization");
	 * this.id=i; this.name=n; this.testMap=hm; }
	 */

	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep Copy
	 * for creating immutable classes
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "first");
		map.put("2", "second");

		String string = "original";

		int i = 10;

		ImmutableClass immutableClass = new ImmutableClass(i, string, map);

		// Lets see whether its copy by field or reference
		System.out.println(string == immutableClass.getName());
		System.out.println(map == immutableClass.getTestMap());
		System.out.println("immutableClass id:" + immutableClass.getId());
		System.out.println("immutableClass name:" + immutableClass.getName());
		System.out.println("immutableClass testMap:" + immutableClass.getTestMap());
		// change the local variable values
		i = 20;
		string = "modified";
		map.put("3", "third");
		// print the values again
		System.out.println("immutableClass id after local variable change:" + immutableClass.getId());
		System.out.println("immutableClass name after local variable change:" + immutableClass.getName());
		System.out.println("immutableClass testMap after local variable change:" + immutableClass.getTestMap());

		HashMap<String, String> hmTest = immutableClass.getTestMap();
		hmTest.put("4", "new");

		System.out.println(
				"immutableClass testMap after changing variable from accessor methods:" + immutableClass.getTestMap());

	}

}