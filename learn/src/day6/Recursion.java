package day6;

import java.util.Scanner;

public class Recursion {

	public static int factorial(int n) {
		//int f = 1;
//		for(int i=1; i<n;i++) {
//			f = f * i;
//		}
		if (n==0 || n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(factorial(number));
	}
	


}
