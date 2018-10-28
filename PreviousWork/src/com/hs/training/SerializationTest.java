package com.hs.training;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class SerializabelClass implements Serializable, ObjectInputValidation {

	private String msg;
	private final int i;
	private transient int x;
	private final transient int y;

	public SerializabelClass(String msg, int i, int x, int  y ) {
		System.out.println("constructor calling");
		this.msg = msg;
		this.i=i;
		this.x=x;
		this.y=y;
	}

	public String getMsg() {
		return msg;
	}

	public int getI() {
		return i;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("writeObject");
		out.defaultWriteObject();
	}

	private Object writeReplace() throws ObjectStreamException {
		System.out.println("writeReplace");
		return this;
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		System.out.println("readObject");
		in.registerValidation(this, 0);
		in.defaultReadObject();
	}

	@Override
	public void validateObject() throws InvalidObjectException {
		System.out.println("validateObject");
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("readResolve");
		return this;
	}
}

public class SerializationTest {

	public static void main(String[] args) throws Exception {
		SerializabelClass pojo = new SerializabelClass("Hello world", 10, 4, 3);
		byte[] bytes = serialize(pojo); // Serialization
		SerializabelClass p = (SerializabelClass) deserialize(bytes); // De-serialization
		System.out.println(p.getMsg());
		System.out.println(p.getI());
		System.out.println(p.getX());
		System.out.println(p.getY());
	}

	private static byte[] serialize(Object o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.flush();
		oos.close();
		return baos.toByteArray();
	}

	private static Object deserialize(byte[] bytes)
			throws ClassNotFoundException, IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}