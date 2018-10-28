package com.hs.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

import javax.xml.bind.DatatypeConverter;

class AnotherClass implements Serializable {
	private static final long serialVersionUID = -6033426231897334231L;
	private String propertyOne;

	public AnotherClass(String propertyOne) {
		this.propertyOne = propertyOne;
	}

	private void writeObject(ObjectOutputStream o) throws IOException {
		o.defaultWriteObject();
		propertyOne = propertyOne + " modified in writeObect block";
		o.writeObject(propertyOne);
	}

	private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {
		o.defaultReadObject();
		propertyOne = (String) o.readObject();
		propertyOne = propertyOne + " again modified in readObject block";
	}

	public String getPropertyOne() {
		return propertyOne;
	}
}

public class CustomSerialization {

	public static byte[] readFileAsByteArray(String fle) throws IOException {
		RandomAccessFile f = new RandomAccessFile(new File(fle), "r");

		try {
			int length = (int) f.length();
			byte[] data = new byte[length];
			f.readFully(data);
			return data;
		} finally {
			f.close();
		}
	}

	public static void main(String[] args) throws Exception {

		AnotherClass testWrite = new AnotherClass("valueOne");
		try (FileOutputStream fos = new FileOutputStream("testfile");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(testWrite);
			System.out.println(testWrite.getPropertyOne());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			byte[] bytes = CustomSerialization.readFileAsByteArray("E:/Java Interview/Interview Preparation/testfile");
			System.out.println(DatatypeConverter.printHexBinary(bytes));
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}