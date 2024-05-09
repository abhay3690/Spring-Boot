package day5;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
	public static void Reverse(int numbers[]) {
		int start = 0, end = numbers.length - 1;
		while (start < end) {
			int temp = numbers[end];
			numbers[end] = numbers[start];
			numbers[start] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter : ");
		int a = sc.nextInt();
		int numbers[] = new int[a];
		for (int i = 0; i < a; i++) {
			numbers[i] = sc.nextInt();
		}
		Reverse(numbers);
//	There are three types of Method  to print number
		
		
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
		
//		for (int i : numbers) {
//			System.out.println(i);
//		}
		
		String as = Arrays.toString(numbers);
		System.out.println(as);
	}

}
