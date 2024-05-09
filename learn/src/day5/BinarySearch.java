package day5;

import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(int numbers[],int key) {
		int start = 0,end =numbers.length;
		while(start<=end) {
			int mid = (start + end)/2;
			if (numbers[mid]==key) {
				return mid;
			}
			else if(numbers[mid]<key) {
				start =mid+1;
			}
			else {
				end = mid -1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int key = sc.nextInt();
		int numbers[] = new int[a];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		binarySearch(numbers,key);
		System.out.println(binarySearch(numbers,key));

	}
}
