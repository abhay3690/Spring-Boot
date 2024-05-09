package day8;

import java.io.*;

public class FileWriteExample {
	public static void main(String[] args) {
		
		String inputFile = "input.txt";
		String outputFile = "output.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));

				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			
			String line;

			while ((line = reader.readLine()) != null) {

				writer.write(line);

				writer.newLine();
			}
			System.out.println("File reading and writing completed successfully.");
		} catch (IOException e) {

			System.err.println("Error: " + e.getMessage());
		}
	}
}
