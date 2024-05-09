
package day6;

import java.util.Scanner;

public class Method_Without_RetuenType {
	public static void Adition(int q,int r) {
		System.out.println(q+r);
	}
	public static void Division(int q,int r) {
		System.out.println(q/r);
	}
	public static void Multiplication(int q,int r) {
		System.out.println(q*r);
	}
	public static void Substraction(int q,int r) {
		System.out.println(q-r);
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a Number a : ");
		int a = sc.nextInt();
		System.out.println("Enter a Number b : ");
		int b = sc.nextInt();
//		Adition(a,b);
//		System.out.println(Division(a,b)+" "+Substraction(a, b)+" "+Multiplication(a,b));
		Adition(a, b);
		Division(a, b);
		Multiplication(a, b);
		Substraction(a, b);		
	}

}
