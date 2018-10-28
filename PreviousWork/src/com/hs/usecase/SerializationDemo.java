package com.hs.usecase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C implements Serializable {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("static block C");
	}
	{
		System.out.println("instance block C");
	}

	C() {
		System.out.println("Constructor C");
	}
}

class B implements Serializable {
	private static final long serialVersionUID = 1L;
	C c = new C();
	static {
		System.out.println("static block B");
	}
	{
		System.out.println("instance block B");
	}

	B() {
		System.out.println("Constructor B");
	}
}

class A implements Serializable {
	private static final long serialVersionUID = 1L;
	B b = new B();
	int i = 5;
}

public class SerializationDemo {
	public static void main(String[] args) {
		A a = new A();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("abc.ser"));
			oos.writeObject(a);
			System.out.println("serialization done");
			ois = new ObjectInputStream(new FileInputStream("abc.ser"));
			A a1 = (A) ois.readObject();
			System.out.println(a1.i);
			System.out.println(a.b);
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