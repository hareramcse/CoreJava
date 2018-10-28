package com.hs.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileReadInJava7 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		try {
			Path file = Paths.get("File.txt");

			List<String> readAllLines = Files.readAllLines(file,
					StandardCharsets.UTF_8);
			
			FileWriter fw = new FileWriter(new File("E:/Movies/temp" + ".sql"));
			for (String string : readAllLines) {
				fw.write(string);
				fw.write("\n");
				System.out.println(string);
			}
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert(
				(endTime - startTime), TimeUnit.NANOSECONDS);
		System.out
				.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
	}
}
