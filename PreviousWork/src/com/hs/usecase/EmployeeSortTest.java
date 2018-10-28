package com.hs.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Employee {
	private int salary;
	private String name;
	private long rent;
	private double emi;
	private Date date;

	Employee(int sal, String name) {
		this.salary = sal;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (rent ^ (rent >>> 32));
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rent != other.rent)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
}

class EmployeeSortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		if (arg0.getName().compareTo(arg1.getName()) == 0) {
			return new EmployeeSortBySalary().compare(arg0, arg1);
		}
		return arg0.getName().compareTo(arg1.getName());
	}
}

class EmployeeSortBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		if (arg0.getSalary() < arg1.getSalary()) {
			return -1;
		} else if (arg0.getSalary() > arg1.getSalary()) {
			return 1;
		}
		return 0;
	}

}

class EmployeeStrategy {
	EmployeeSortByName byName = new EmployeeSortByName();
	EmployeeSortBySalary bySalary = new EmployeeSortBySalary();

	public Comparator<Employee> getComparator(String sort) {
		if (sort.equalsIgnoreCase("by salary")) {
			return bySalary;
		} else {
			return byName;
		}
	}
}

public class EmployeeSortTest {
	public static void main(String[] args) {
		Employee employee1 = new Employee(100, "Hareram");
		Employee employee2 = new Employee(200, "Raghuraj");
		Employee employee3 = new Employee(300, "Saroj");
		Employee employee4 = new Employee(400, "Aman");
		Employee employee5 = new Employee(200, "Aman");
		Employee employee6 = new Employee(600, "Aman");
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		empList.add(employee5);
		empList.add(employee6);

		EmployeeStrategy strategy = new EmployeeStrategy();

		Collections.sort(empList, strategy.getComparator("by name"));
		for (Employee emp : empList)
			System.out.println(emp.getName() + "  " + emp.getSalary());
		Collections.sort(empList, strategy.getComparator("by salary"));
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,");
		for (Employee emp : empList)
			System.out.println(emp.getName() + "  " + emp.getSalary());
	}
}
