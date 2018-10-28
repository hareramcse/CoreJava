package com.hs.memoryLeak;

import java.util.HashMap;
import java.util.Map;

class Employee {
	private String name;
	private int salary;

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
}

public class MemoryLeak {
	public static void main(String[] args) throws InterruptedException {
		String a = "a";
		int counter = 1;
		Map<String, Employee> empMap = new HashMap<String, Employee>();
		for (;;) {

			empMap.put(a + counter++, new Employee());
			Thread.sleep(1000);
			if (counter > 10000)
				break;
		}
	}
}
