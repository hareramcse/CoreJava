package com.hs.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Serailize implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object writeReplace() {
		System.out.println("writeReplace block execution starts");
		Serailize serailize = new Serailize();
		serailize.setName("value changes inside WriteReplace Method");
		System.out.println("writeReplace block execution ends");
		return serailize;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out.println("writeObject block execution starts");
		oos.defaultWriteObject();

		System.out.println("writeObject block execution ends");
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		System.out.println("readObject block execution starts");
		ois.defaultReadObject();

		System.out.println("readObject block execution ends");
	}

	public Object readResolve() {
		System.out.println("readResolve block execution starts");
		Serailize serailize = new Serailize();
		serailize.setName("value changes inside readResolve Method");
		System.out.println("readResolve block execution ends");
		return serailize;
	}

}

public class SerializationSequenceCheck {
	public static void main(String[] args) {
		Serailize serailize = new Serailize();

		try (FileOutputStream fos = new FileOutputStream(new File("abc.ser"));
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream("abc.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			System.out.println("Serialization started");
			oos.writeObject(serailize);
			System.out.println("Serialization end");

			System.out.println(".........................");

			System.out.println("Deserialization started");
			Serailize deSerailize = (Serailize) ois.readObject();
			System.out.println("if we dont override readResolve method then value will be : "
					+ "value changes inside WriteReplace Method");
			System.out.println("after Deserialization value is : " + deSerailize.getName());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}