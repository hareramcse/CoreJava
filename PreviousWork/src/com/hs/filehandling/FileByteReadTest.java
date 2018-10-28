package com.hs.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileByteReadTest {
	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "File.txt";
		File file = new File(fileName);

		try {
			// Use this for reading the data.
			byte[] buffer = new byte[(int) file.length()];
			System.out.println("Size of the file is " + file.length());

			FileInputStream fis = new FileInputStream(file);

			// read fills buffer with data and returns
			// the number of bytes read (which of course
			// may be less than the buffer size, but
			// it will never be more).
			while (fis.read(buffer) != -1) {
				System.out.println(new String(buffer));
			}
			// Always close files.
			fis.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}