package com.hs.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Retailer {
	private int id;
	private String name;
	private Integer salary;

	public Retailer(int id, String name, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
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
		if (ret1.getName().equals(ret2.getName())) {
			return new SortBySalary().compare(ret1, ret2);
		}
		return ret1.getName().compareTo(ret2.getName());
	}
}

class SortBySalary implements Comparator<Retailer> {

	public int compare(Retailer ret1, Retailer ret2) {
		return ret1.getSalary().compareTo(ret2.getSalary());
	}
}

public class SortByComparator {
	public static void main(String[] args) {
		List<Retailer> list = new ArrayList<Retailer>();
		list.add(new Retailer(1, "Hare", 1000));
		list.add(new Retailer(12, "Ram", 2000));
		list.add(new Retailer(11, "Singh", 1500));
		list.add(new Retailer(14, "Ram", 1000));
		list.add(new Retailer(16, "Raj", 4000));
		list.add(new Retailer(13, "Hare", 900));

		Collections.sort(list, new SortByid());
		for (Retailer ret : list) {
			System.out.println(ret.getId() + " " + ret.getName() + " "
					+ ret.getSalary());
		}

		System.out.println("========================");

		Collections.sort(list, new SortByName());
		for (Retailer ret : list) {
			System.out.println(ret.getId() + " " + ret.getName() + " "
					+ ret.getSalary());
		}
	}
}