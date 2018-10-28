package com.hs.enumm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

interface A {
	int i = 10;
}

enum enumC implements A {
	INSTANCE;
}

public class EnumInheritance {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println(enumC.INSTANCE);
		System.out.println(enumC.i);

		enumC c = enumC.INSTANCE;
		//c.clone();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enum.ser"));
		oos.writeObject(enumC.INSTANCE);
		System.out.println("Serialization done");

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enum.ser"));
		enumC e = (enumC) ois.readObject();
		System.out.println(e.INSTANCE);
		System.out.println(e.name());
	}
}