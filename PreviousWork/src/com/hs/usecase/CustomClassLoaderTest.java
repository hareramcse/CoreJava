package com.hs.usecase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class CustomClassLoader extends ClassLoader {
	public Class<?> findClass(String name) {
		System.out.println("helo findclss");
		byte[] bt = loadClassData(name);
		return defineClass(name, bt, 0, bt.length);
	}

	private byte[] loadClassData(String className) {
		System.out.println("hello lodclss");
		// read the class file
		InputStream is = CustomClassLoader.class.getClassLoader()
				.getResourceAsStream(className.replace(".", "/") + ".class");
		ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
		// write into byte
		int len = 0;
		try {
			while ((len = is.read()) != -1) {
				byteSt.write(len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// convert into byte array
		return byteSt.toByteArray();
	}
}

class CustomClass {
	public void show() {
		System.out.println("Hello World!");
	}
}

public class CustomClassLoaderTest {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {

		CustomClassLoader loader = new CustomClassLoader();
		Class<?> c = loader.findClass("com.hs.CustomClassTest");
		Object ob = c.newInstance();
		Method md = c.getMethod("show");
		md.invoke(ob);
		System.out.println(CustomClass.class.getClassLoader().getClass()
				.getName());
	}
}
