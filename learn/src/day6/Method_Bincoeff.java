package day6;

import java.util.Scanner;

public class Method_Bincoeff {
	public static int bincoeff(int n,int r) {
		
		int fa_n = Method_Factorial.factorial(n); 	 
		int fa_r = Method_Factorial.factorial(r);
		int fa_nr = Method_Factorial.factorial(n-r);
		int bincoeff = fa_n / (fa_r * fa_nr);
		return bincoeff;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of A : ");
		int a = sc.nextInt();
		System.out.println("Enter number of B : ");
		int b = sc.nextInt();
		System.out.println(bincoeff(a,  b));

	}

}
