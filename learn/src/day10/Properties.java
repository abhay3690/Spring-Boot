package day10;

import java.util.ArrayList;

public class Properties {
	    public static void main(String[] args) {
	        // Create an ArrayList
	        ArrayList<String> fruits = new ArrayList<>();
	        // Add elements to the ArrayList
	        fruits.add("Apple");
	        fruits.add("Banana");
	        fruits.add("Orange");

	        // Access elements by index
	        System.out.println("First fruit: " + fruits.get(0));

	        // Iterate through the ArrayList
	        System.out.println("All fruits:");
	        for (String fruit : fruits) {
	            System.out.println(fruit);
	        }
	    }
	}


