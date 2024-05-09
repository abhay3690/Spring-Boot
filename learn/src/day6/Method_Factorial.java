package day6;

import java.util.Scanner;

public class Method_Factorial {
	public static int factorial(int n) {
		int f = 1;
		for(int i=1; i<n;i++) {
			f = f * i;
		}
		return f;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int fact =factorial(number);
		System.out.println(fact);
	}

}
