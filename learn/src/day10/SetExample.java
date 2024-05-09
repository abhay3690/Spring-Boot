package day10;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		set.add(10); // Add an integer
		set.add('A'); // Add a character
		set.add("Hello"); // Add a string
		set.add(20); // Add another integer (duplicate)
		set.add('B'); // Add another character
		set.add("World"); // Add another string

		System.out.println("Set elements: " + set);

		System.out.println("Size of set: " + set.size());

		System.out.println("Does 'Hello' exist in the set? " + set.contains("Hello"));

		set.remove('A');

		System.out.println("Updated set after removing 'A': " + set);

		System.out.println("Iterating over the set:");
		for (Object element : set) {
			System.out.println(element);
		}

		set.clear();
		System.out.println("Set cleared. Is set empty now? " + set.isEmpty());
	}
}
