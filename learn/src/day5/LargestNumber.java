package day5;

import java.util.Scanner;

public class LargestNumber {
	public static int getLargest(int numbers[]) {
		int largest = Integer.MIN_VALUE;
		int small = Integer.MAX_VALUE;
		for(int i = 0; i< numbers.length;i++) {
			if(largest<numbers[i]) {
				largest = numbers[i];
			}
			if(small>numbers[i]) {
				small = numbers[i];
			}
		}
		System.out.println("Your smallest number is : "+small);
		return largest;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("Enter a size of index :");
		int numbers[] =new int[a]; 
//		int numbers []= {518,59,18,28,274,52,154,45};
		for(int i = 0; i<a;i++) {
			numbers[i] = sc.nextInt();
		}
		int key = getLargest(numbers);
		System.out.println(key);
	}

}
