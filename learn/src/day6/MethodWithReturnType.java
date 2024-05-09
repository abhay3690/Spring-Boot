package day6;

import java.util.Scanner;

public class MethodWithReturnType {
	
	public static int Adition(int a,int b) {
		return a+b;
	}
	public static int Division(int a,int b) {
		return a/b;
	}
	public static int Multiplication(int a,int b) {
		return a*b;
	}
	public static int Substraction(int a,int b) {
		return a-b;
	}
	public static void main(String[] args) {
		int index;
		Scanner sc = new Scanner(System.in);  
        System.out.print("Enter a number 1: ");  
        int e1 = sc.nextInt(); 
        System.out.print("Enter a number 2: ");
        int e2 = sc.nextInt(); 
        System.out.println(Adition(e1,e2)+" "+Division(e1,e2)+" "+Substraction(e1, e2)+" "+Multiplication(e1,e2));
        
	}
}
