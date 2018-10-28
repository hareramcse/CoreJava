package com.hs.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/*
 * Yes they are. As is well-known, Java serialization keeps a record of every object written to a stream. 
 * If the same object is encountered a second time, only a reference to it is written to the stream, 
 * and not a second copy of the object; so circular references aren't the problem here.
 */
class A implements Serializable {
	private static final long serialVersionUID = 1L;
	List<B> b;
}

class B implements Serializable {
	private static final long serialVersionUID = 1L;
	List<A> a;
}

public class CyclickSerialization {
	public static void main(String[] args) throws IOException {
		A a = new A();

		new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(a);
		System.out.println("It works");
	}
}
