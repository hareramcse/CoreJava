package com.hs.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class User implements Externalizable {
	String name;
	double salary;
	int age;

	public User() {

	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(age);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		age = in.readInt();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class ExternalizationDemo {
	private String filePath = "user.ser";

	public void serialize() throws IOException {
		User user = new User();

		user.setName("Hareram");
		user.setAge(20);
		user.setSalary(1000);

		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream outputStream = new ObjectOutputStream(fos);
		outputStream.writeObject(user);
		outputStream.close();

		System.out.println("after serialization ");
		System.out.println("Name is " + user.getName());
		System.out.println("Age is " + user.getAge());
		System.out.println("Salary is " + user.getSalary());
	}

	public void deserialize() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream inputStream = new ObjectInputStream(fis);
		User user = (User) inputStream.readObject();
		inputStream.close();

		System.out.println("after deserialization ");
		System.out.println("Name is " + user.getName());
		System.out.println("Age is " + user.getAge());
		System.out.println("Salary is " + user.getSalary());
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ExternalizationDemo demo = new ExternalizationDemo();
		demo.serialize();
		System.out.println(".................");
		demo.deserialize();
	}
}