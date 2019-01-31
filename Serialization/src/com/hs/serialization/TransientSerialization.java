package com.hs.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TransientClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient String propertyOne;
	private static int staticValue;

	public TransientClass(String propertyOne) {
		this.propertyOne = propertyOne;
	}

	private void writeObject(ObjectOutputStream o) throws IOException {
		o.defaultWriteObject();
		String s = propertyOne + "modified";
		o.writeObject(s);
	}

	private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {

		o.defaultReadObject();

		String s = (String) o.readObject();
		propertyOne = s.substring(0, 8);

	}

	public String getPropertyOne() {
		return propertyOne;
	}

	public static int getStaticValue() {
		return staticValue;
	}

	public static void setStaticValue(int staticValue) {
		TransientClass.staticValue = staticValue;
	}
}

public class TransientSerialization {

	public static void main(String[] args) throws Exception {

		TransientClass testWrite = new TransientClass("valueOne");
		TransientClass.setStaticValue(20);
		FileOutputStream fos = new FileOutputStream("testfile");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(testWrite);
		oos.flush();
		oos.close();

		System.out.println("--Serialized object--");
		System.out.println("propertyOne: " + testWrite.getPropertyOne());
		System.out.println("staticValue: " + TransientClass.getStaticValue());
		System.out.println("");

		FileInputStream fis = new FileInputStream("testfile");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TransientClass testRead = (TransientClass) ois.readObject();
		ois.close();

		System.out.println("--Read object--");
		System.out.println("propertyOne: " + testRead.getPropertyOne());
		System.out.println(
				"static variables are not serialized, So during deserialization static variable value will loaded from the class.(Current value will be loaded.");
		System.out.println("staticValue: " + TransientClass.getStaticValue());
	}
}