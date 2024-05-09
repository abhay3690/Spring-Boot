package day1;

import java.util.Scanner; 
public class constatnt_private {
	 public static void main(String[] args)  
	 { 
		 int a,b;
		 System.out.println("Enter a number a : ");
		 Scanner sc = new Scanner(System.in);
		 a = sc.nextInt();
		 System.out.println("Enter a number b : ");
		 Scanner sc1 = new Scanner(System.in);
		 b = sc1.nextInt();
		
		 System.out.println("Your adition number is : "+(a+b));
		 System.out.println("Your substraction number is : "+(a-b));
		 System.out.println("Your multiuplication number is : "+(a*b));
		 System.out.println("Your division number is : "+(a/b));	
	 }  
	 
}
