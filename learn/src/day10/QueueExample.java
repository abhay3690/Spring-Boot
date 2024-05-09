package day10;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<String> queue1 = new LinkedList<>();
		queue1.add("Apple");
		queue1.add("Banana");
		queue1.add("Orange");
		System.out.println("Queue: " + queue1);
		String removedElement1 = queue1.remove();
		System.out.println("Removed Element: " + removedElement1);
		System.out.println("Updated Queue: " + queue1);
		String frontElement1 = queue1.peek();
		System.out.println("Front Element: " + frontElement1);
		boolean isEmpty1 = queue1.isEmpty();
		System.out.println("Is Queue Empty? " + isEmpty1);

		Queue<String> queue = new LinkedList<>();
		queue.offer("Apple");
		queue.offer("Banana");
		queue.offer("Orange");
		System.out.println("Queue: " + queue);
		String removedElement = queue.poll();
		System.out.println("Removed Element: " + removedElement);
		System.out.println("Updated Queue: " + queue);
		String frontElement = queue.peek();
		System.out.println("Front Element: " + frontElement);
		boolean isEmpty = queue.isEmpty();
		System.out.println("Is Queue Empty? " + isEmpty);
	}

}
