package com.hs.collection;

import java.util.Enumeration;
import java.util.Vector;

public class IteratorExample {

	public static void main(String args[]) {
		/*List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		List myList1 = Collections.synchronizedList(myList);
		Iterator<String> it = myList1.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
		} */
		
		// we can't use enumeration with ArrayList
		/*List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		Enumeration<String> enumeration = Collections.enumeration(myList);
		myList.add("after");
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		} */
		
		/*Vector<String> vct = new Vector<String>();
		vct.add("First");
		vct.add("Second");
		vct.add("Third");
		vct.add("Random");
		Iterator<String> itr = vct.iterator();
		vct.add("after");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}*/
	
		/*Vector<String> vct = new Vector<String>();
		vct.add("First");
		vct.add("Second");
		vct.add("Third");
		vct.add("Random");
		Enumeration<String> enumeration = vct.elements();
		vct.add("after");
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}*/
		
		/*Vector<String> vct = new Vector<String>();
		vct.add("First");
		vct.add("Second");
		vct.add("Third");
		vct.add("Random");
		Iterator<String> itr = vct.iterator();*/
		
	}
}
