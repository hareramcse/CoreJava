package com.hs.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent {
	protected int field;

	protected Parent() {
		field = 5;
		System.out.println("Parent::Constructor");
	}

	public int getField() {
		return field;
	}

	static {
		System.out.println("Parent static");
	}

	{
		System.out.println("Parent instance block");
	}
}

class Child extends Parent implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int i;

	public Child(int i) {
		this.i = i;
		System.out.println("Child::Constructor");
	}

	public int getI() {
		return i;
	}

	static {
		System.out.println("Child static");
	}

	{
		System.out.println("Child instance block");
	}
}

public class InheritanceCheck {

	public static void main(String[] args) {
		try {
			System.out.println("Main method started");
			Child child = new Child(1);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			child.field = 10;
			System.out.println("Serialization started");
			oos.writeObject(child);
			oos.flush();
			baos.flush();
			oos.close();
			baos.close();
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			System.out.println("Deserialization started");
			Child c1 = (Child) ois.readObject();
			System.out.println("c1.i=" + c1.getI());
			System.out.println("c1.field=" + c1.getField());
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
