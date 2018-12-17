package com.hs.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Retailer {
	private int id;
	private String name;

	public Retailer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name;
	}

}

class SortByid implements Comparator<Retailer> {

	public int compare(Retailer ret1, Retailer ret2) {
		if (ret1.getId() < ret2.getId()) {
			return -1;
		} else if (ret1.getId() > ret2.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}

class SortByName implements Comparator<Retailer> {

	public int compare(Retailer ret1, Retailer ret2) {

		return ret1.getName().compareTo(ret2.getName());

	}

}

public class SortByComparator {
	public static void main(String[] args) {
		List<Retailer> list = new ArrayList<Retailer>();
		list.add(new Retailer(1, "Hare"));
		list.add(new Retailer(12, "Ram"));
		list.add(new Retailer(11, "Singh"));
		list.add(new Retailer(14, "Raghu"));
		list.add(new Retailer(16, "Raj"));
		list.add(new Retailer(13, "Kuamr"));
		list.add(new Retailer(7, "Rahul"));
		list.add(new Retailer(4, "Saroj"));
		list.add(new Retailer(5, "Santosh"));
		list.add(new Retailer(2, "Triloki"));

		Collections.sort(list, new SortByid());
		System.out.println(list);
		Collections.sort(list, new SortByName());
		System.out.println(list);

	}
}
