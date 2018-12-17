package com.hs.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Resource implements Comparable<Resource> {
	String name;
	int salary;
	String address;

	Resource(String name, int salary, String address) {
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	/*
	 * for the first entry of the object(122) it wont be called. when we insert
	 * second object(127) in the list to sort the object then it will be called
	 * so here current object will be first object(122) and resource will be the
	 * second object(127). so it will compare first object and second object. as
	 * (122<127) so it will return -1. as of now 1st object is already smaller
	 * than 2nd object so no swapping will happen.
	 * 
	 * in the third entry of the object(123), second object(127) is current
	 * object and resource will be third object(123). so current object(127) and
	 * third object(123) will be compared (127>123) so it will return 1 and both
	 * object will be swapped so second object is now third object and third
	 * object is second object and current object pointer will move to the 1st
	 * object(122). till here sequence will be like 122 123 127 and current
	 * object pointer is 122
	 * 
	 * so now there will be comparison between current object(122) and second
	 * object(123). as (122<123) so there will be no swapping of the objects.
	 * and if all the comparison are over then current object pointer will point
	 * to bigger value which is 127 here. so till now sequence is like
	 * 122,123,127 and current object will 127.
	 * 
	 * in the 4th entry of the object(125), current object is 127 and resource
	 * object is 125. so there will be comparison between(127>125) as 127 is
	 * greater than 125 so it will return 1 and there will be swapping of 125
	 * and 127 and current object pointer will move to second greatest value in
	 * the array as of now(123). and now current object is 123 and resource
	 * object is 125.now there will be comparison between 123 and 125, as
	 * (123<125) so there will no swapping and current object pointer will move
	 * to biggest object(127). as till object(123) is already sorted so it wont
	 * go and check with object(122).
	 * 
	 * so till now object sequence will be like 122, 123, 125, 127 and current
	 * object pointer is(127).
	 * 
	 * this process will go on till whole list of object is not sorted.
	 */
	
	
	public int compareTo(Resource resource) {
		// return this.name.compareTo(resource.getName()); // by name
		if (this.salary < resource.salary) { // by salary
			return -1;
		} else if (this.salary > resource.salary) {
			return 1;
		} else {
			return 0;
		}
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

public class SortObjectClass {
	public static void main(String[] args) {
		List<Resource> list = new ArrayList<Resource>();
		list.add(new Resource("Hare", 122, "BTM"));
		list.add(new Resource("Saroj", 127, "Mum"));
		list.add(new Resource("Raj", 123, "Pune"));
		list.add(new Resource("Naresh", 125, "Delhi"));
		list.add(new Resource("Mohan", 124, "Chenai"));
		list.add(new Resource("Rahul", 126, "Kol"));

		Collections.sort(list);
		for (Resource resource : list) {
			System.out.println(resource.getName() + " ---"
					+ resource.getSalary() + "---" + resource.getAddress());
		}
	}
}
