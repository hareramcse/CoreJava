package com.hs.durga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

public class EmployeeComparator {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("santu", 1000));
		list.add(new Employee("Raghu", 50000));
		list.add(new Employee("mantu", 8000));
		list.add(new Employee("Hare", 9000));

		Collections.sort(list, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		System.out.println(list);
	}

}
