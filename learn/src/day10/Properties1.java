package day10;

import java.util.ArrayList;

public class Properties1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Orange");
		list.add("Banana");
		list.add("");
		System.out.println("Size of ArrayList: " + list.size());
		System.out.println("Contents of ArrayList: " + list);
		System.out.println("Element at index 1: " + list.get(1));

		list.set(3, "Grapes");
		System.out.println("Modified ArrayList: " + list);
		list.remove("Banana");
		System.out.println("ArrayList after removing 'Banana': " + list);

		System.out.println("Does 'Apple' exist in ArrayList? " + list.contains("Apple"));

		System.out.println("Iterating through ArrayList:");
		for (String item : list) {
			System.out.println(item);
		}

		String[] array = new String[list.size()];
		list.toArray(array);
		System.out.println("ArrayList converted to array:");
		for (String item : array) {
			System.out.println(item);
		}
		list.clear();
		System.out.println("ArrayList after clearing: " + list);
	}
}
