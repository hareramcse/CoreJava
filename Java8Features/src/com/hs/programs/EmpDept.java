package com.hs.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmpDept {
	public static List<Employee> feedData() {
		Department d1 = new Department(1, "HR", 100);
		Department d2 = new Department(2, "IT", 200);
		Department d3 = new Department(3, "Adops", 300);
		Department d4 = new Department(4, "Finance", 400);

		Employee e1 = new Employee(1, "A", 10000, d1);
		Employee e2 = new Employee(2, "B", 20000, d1);
		Employee e3 = new Employee(3, "C", 30000, d1);
		Employee e4 = new Employee(4, "D", 40000, d1);

		Employee e5 = new Employee(5, "E", 50000, d2);
		Employee e6 = new Employee(6, "F", 60000, d2);
		Employee e7 = new Employee(7, "G", 70000, d2);
		Employee e8 = new Employee(8, "H", 80000, d2);

		Employee e9 = new Employee(9, "I", 90000, d3);
		Employee e10 = new Employee(10, "J", 100000, d3);
		Employee e11 = new Employee(11, "K", 110000, d3);

		Employee e12 = new Employee(12, "L", 120000, d4);
		Employee e13 = new Employee(13, "M", 130000, d4);
		Employee e14 = new Employee(14, "N", 140000, d4);
		Employee e15 = new Employee(15, "O", 150000, d4);
		Employee e16 = new Employee(16, "P", 160000, d4);

		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		empList.add(e7);
		empList.add(e8);
		empList.add(e9);
		empList.add(e10);
		empList.add(e11);
		empList.add(e12);
		empList.add(e13);
		empList.add(e14);
		empList.add(e15);
		empList.add(e16);
		return empList;
	}

	public static void main(String[] args) {
		List<Employee> empList = feedData();

		System.out.println(
				"Find all employees who belongs to HR, sort them by their name and print the names of employees.");
		empList.stream().filter(e -> e.getDepartment().getDeptName().equals("HR"))
				.sorted(Comparator.comparing(Employee::getName)).forEach(a -> System.out.println(a.getName()));

		System.out.println("Print all employee’s name who are working for IT department.");
		empList.stream().filter(e -> e.getDepartment().getDeptName().equals("IT"))
				.forEach(a -> System.out.println(a.getName()));

		System.out.println("What is the highest number of of employees in all departments?");
		empList.stream().map(e -> e.getDepartment().getNoOfEmployee()).reduce(Integer::max)
				.ifPresent(System.out::println);

		System.out.println("Find the department name which has the highest number of employees.");
		empList.stream()
				.reduce((a, b) -> a.getDepartment().getNoOfEmployee() > b.getDepartment().getNoOfEmployee() ? a : b)
				.ifPresent(a -> System.out.println(a.getDepartment().getDeptName()));

		System.out.println("Find the total number of employees in all the departments.");
		empList.stream().map(e -> e.getDepartment().getNoOfEmployee()).distinct().reduce(Integer::sum)
				.ifPresent(System.out::println);

		System.out.println("Group the emp by deptname");
		empList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((a, b) -> {
			System.out.println(a.getDeptName());
			b.forEach(c -> System.out.println(c.getName()));
		});

		System.out.println("find the highest salary of the emp by dept");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))))
				.forEach((a, b) -> {
					System.out.println(a.getDeptName());
					System.out.println(b.get().getName());
				});
	}
}
