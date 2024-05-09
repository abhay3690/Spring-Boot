package day9;


import java.io.StringWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringBuffer_StringReader {
	public static void main(String[] args) {
		// 1. String
		String str = "Hello, World!";

		// 2. StringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello");
		stringBuilder.append(", "); 
		stringBuilder.append("World!");
		String result1 = stringBuilder.toString();
		System.out.println("StringBuilder result: " + result1); // Output: Hello, World!

		// 3. StringBuffer
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Hello");
			stringBuffer.append(", ");
			stringBuffer.append("World!");
			String result2 = stringBuffer.toString();
			System.out.println("StringBuffer result: " + result2); // Output: Hello, World!
		
		

		// 4. StringTokenizer
		String sentence = "This is a sentence.";
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println("Token: " + token);
		}

		// 5. StringJoiner
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		joiner.add("Apple");
		joiner.add("Banana");
		joiner.add("Orange");
		String fruits = joiner.toString();
		System.out.println("Fruits: " + fruits); // Output: [Apple, Banana, Orange]
		

		// 7. StringWriter and StringBufferOutputStream
		StringWriter writer = new StringWriter();
		writer.write("Hello, World!");
		StringBuffer buffer = writer.getBuffer();
		String writtenText = buffer.toString();
		System.out.println("\nWritten text: " + writtenText); // Output: Hello, World!
	}
}
