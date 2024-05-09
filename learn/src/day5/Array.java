package day5;

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
//		System.out.println("Hii there.");
//		int []marks = new int[3];
//		marks[0] = 97;
//		marks[1] = 85;
//		marks[2] = 44;
//		System.out.println(marks[0]);
//		System.out.println(marks[1]);
//		System.out.println(marks[2]);
//		for(int i=0;i<marks.length;i++) {
//			System.out.println(marks[i]);
//		}
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int marks[] = new int[a];
		for (int i = 0; i < a; i++) {
			marks[i] = sc.nextInt();
		}
		for (int i = 0; i < a; i++) {
			System.out.println(marks[i]);
		}
	}
}
