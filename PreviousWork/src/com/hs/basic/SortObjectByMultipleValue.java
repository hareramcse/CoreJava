package com.hs.previouswork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Seller implements Comparable<Seller> {
	String name;
	Integer salary;
	String address;

	Seller(String name, int salary, String address) {
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public int compareTo(Seller seller) {
		int i = name.compareTo(seller.name);
		if (i != 0)
			return i;

		i = address.compareTo(seller.address);
		if (i != 0)
			return i;

		return salary.compareTo(seller.salary);
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

class EmployeeChainedComparator implements Comparator<Seller> {

	private List<Comparator<Seller>> listComparators;

	public EmployeeChainedComparator(Comparator<Seller>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	public int compare(Seller seller1, Seller seller2) {
		for (Comparator<Seller> comparator : listComparators) {
			int result = comparator.compare(seller1, seller2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}

class SellerNameComparator implements Comparator<Seller> {

	public int compare(Seller seller1, Seller seller2) {
		return seller1.getName().compareTo(seller2.getName());
	}
}

class SellerSalaryComparator implements Comparator<Seller> {

	public int compare(Seller seller1, Seller seller2) {
		return seller1.getSalary().compareTo(seller2.getSalary());
	}
}

class SellerAddressComparator implements Comparator<Seller> {

	public int compare(Seller seller1, Seller seller2) {
		return seller1.getAddress().compareTo(seller2.getAddress());
	}
}

public class SortObjectByMultipleValue {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Seller> list = new ArrayList<Seller>();
		list.add(new Seller("Hare", 122, "BTM"));
		list.add(new Seller("Hare", 122, "Mara"));
		list.add(new Seller("Hare", 123, "Jai"));
		list.add(new Seller("Saroj", 127, "Mum"));
		list.add(new Seller("Raj", 123, "Pune"));
		list.add(new Seller("Naresh", 125, "Delhi"));
		list.add(new Seller("Mohan", 124, "Chenai"));
		list.add(new Seller("Rahul", 126, "Kol"));

		Collections.sort(list, new EmployeeChainedComparator(
				new SellerNameComparator(), new SellerSalaryComparator(),
				new SellerAddressComparator()));

		for (Seller resource : list) {
			System.out.println(resource.getName() + " ---"
					+ resource.getSalary() + "---" + resource.getAddress());
		}
	}
}
