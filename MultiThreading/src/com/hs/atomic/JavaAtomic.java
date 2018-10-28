package com.hs.atomic;


public class JavaAtomic {

	public static void main(String[] args) throws InterruptedException {

		
		 ProcessingThread pt = new ProcessingThread(); Thread t1 = new
		 Thread(pt, "t1"); t1.start(); Thread t2 = new Thread(pt, "t2");
		 t2.start(); t1.join(); t2.join();
		 System.out.println("Processing count=" + pt.getCount());
		 
/*
		// it shorts based on key
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("abc", "abc");
		treeMap.put("jkl", "def");
		treeMap.put("ghi", "ghi");
		treeMap.put("pqr", "jkl");
		treeMap.put("mno", "mno");
		treeMap.put("djf", "pqr");

		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			System.out.println("key is " + entry.getKey() + " and value is "
					+ entry.getValue());
		}

		System.out.println(".................................");
		Map<String, String> identityMap = new IdentityHashMap<String, String>();
		identityMap.put("abc", "abc");
		identityMap.put("abc", "def");
		identityMap.put("abc", "ghi");
		identityMap.put("pqr", "jkl");
		identityMap.put("mno", "mno");
		identityMap.put("djf", "pqr");
		for (Map.Entry<String, String> entry : identityMap.entrySet()) {
			System.out.println("key is " + entry.getKey() + " and value is "
					+ entry.getValue());
		}*/

		

	}
	
	

}
