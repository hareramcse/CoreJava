package com.hs.previouswork;

class Employee {
	String name;
	int salary;

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	Employee(int salary, String name) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		System.out.println("hash");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (salary != other.salary) {
			return false;
		}
		return true;
	}

}

public class HashMapCheck {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hareram", 10);
		Employee e2 = new Employee(10, "Hare");
		// System.out.println(e1.hashCode());
		// System.out.println(e2.hashCode());
		System.out.println(e1.equals(e2));
	}
}
