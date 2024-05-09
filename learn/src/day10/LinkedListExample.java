package day10;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Monkey");
        list.add("Bhalu");
        list.add("Lio");
        list.add("Cat"); 

        System.out.println("Size of LinkedList: " + list.size());
        System.out.println("Contents of LinkedList: " + list);

        System.out.println("Element at index 1: " + list.get(1));

        list.set(2, "Brownie");
        System.out.println("Modified LinkedList: " + list);

        list.remove("Banana");
        System.out.println("LinkedList after removing 'Banana': " + list);

        System.out.println("Does 'Apple' exist in LinkedList? " + list.contains("Apple"));

        System.out.println("Iterating through LinkedList:");
        for (String item : list) {
            System.out.println(item);
        }
        String[] array = new String[list.size()];
        list.toArray(array);
        System.out.println("LinkedList converted to array:");
        for (String item : array) {
            System.out.println(item);
        }

        list.clear();
        System.out.println("LinkedList after clearing: " + list);
    }
}
