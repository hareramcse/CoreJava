package com.hs.usecase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C1 {
	static {
		System.out.println("static block C");
	}
	{
		System.out.println("instance block C");
	}

	C1() {
		System.out.println("Constructor C");
	}
}

class B1 extends C1 {
	static {
		System.out.println("static block B");
	}
	{
		System.out.println("instance block B");
	}

	B1() {
		System.out.println("Constructor B");
	}
}

class A1 extends B1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int i = 5;
}

public class SerializationDemo1 {
	public static void main(String[] args) {
		A1 a = new A1();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("abc.ser"));
			oos.writeObject(a);
			System.out.println("serialization done");
			ois = new ObjectInputStream(new FileInputStream("abc.ser"));
			A1 a1 = (A1) ois.readObject();
			System.out.println(a1.i);
			System.out.println(Integer.MAX_VALUE);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}