package com.hs.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.HexFormat;

class parent1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int parentVersion = 10;
}

class contain implements Serializable {
	private static final long serialVersionUID = 1L;
	int containVersion = 11;
}

public class SerializationByteCode extends parent1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int version = 66;
	contain con = new contain();

	public int getVersion() {
		return version;
	}

	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		SerializationByteCode st = new SerializationByteCode();
		oos.writeObject(st);
		oos.flush();
		oos.close();

		try {
			byte[] bytes = CustomSerialization.readFileAsByteArray("E:/Workspace/OwnWork/temp");
			System.out.println(HexFormat.of().formatHex(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
}