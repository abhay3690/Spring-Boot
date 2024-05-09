package day10;
import java.util.ArrayList;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
    
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);

        System.out.println("Size of ArrayList: " + list.size());
        System.out.println("Contents of ArrayList: " + list);
        System.out.println("Element at index 1: " + list.get(1));
        list.set(2, 40);
        System.out.println("Modified ArrayList: " + list);
        list.remove(Integer.valueOf(20));
        System.out.println("ArrayList after removing 20: " + list);
        System.out.println("Does 10 exist in ArrayList? " + list.contains(10));
        System.out.println("Iterating through ArrayList:");
        for (int item : list) {
            System.out.println(item);
        }

        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        
        System.out.println("ArrayList converted to array:");
        for (int item : array) {
            System.out.println(item);
        }

        list.clear();
        System.out.println("ArrayList after clearing: " + list);
    }
}
