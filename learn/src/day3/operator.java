package day3;
import java.util.Scanner;

public class operator {
	
	public static void aop(int a,int b) {
		System.out.println("sum of a & b is : "+ (a+b));
		System.out.println("sub of a & b is : "+ (a-b));
		System.out.println("mul of a & b is : "+ (a*b));
		System.out.println("div of a & b is : "+ (a/b));
		System.out.println("remainder of a & b is : "+ (a%b));
	}
	
	public static void rop(int a,int b) {
		System.out.println("The number of Equal to:"+(a==b));
		System.out.println("The number of not Equal to :"+(a!=b));
		System.out.println("The number of Less than :"+(a<b));
		System.out.println("The number of Greater than :"+(a>b));
		System.out.println("The number of lessthan and Equal to :"+(a<=b));
	}
	public static void utop(int a,int b) {
		System.out.println("The number of unnery 1 is :" +(a++) +(b++));
		System.out.println("The number of unnery 2 is :"+(a--) +(b--));
		System.out.println("The number of unnery 3 is :"+(++a) +(++b));
		System.out.println("The number of unnery 4 is :"+(--a) +(--b));
	}
	public static void logi_op(int a,int b) {
		System.out.println("The number of OR operator :"+(a>b || b<a));
		System.out.println("The number of OR operator :"+(a>b && b<a));
	}

	public static int sum(int x,int y) {
		return x+y;
	}
	 public static void main(String []args) {
		 int n, n1;
		 boolean result;	 
		 System.out.println("Enter a number : ");
		 Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		 System.out.println("Enter a Second number : "); 
		 Scanner sc1=new Scanner(System.in);
		 n1=sc1.nextInt();
		 aop(n, n1);
		 rop(n, n1);
		 utop(n, n1);
		 logi_op(n,n1);
		 //int sum1 = sum(n, n1);
		 System.out.println("sum is : "+ sum(n, n1));
		 result = (n%2==0) ? true:false;
		 System.out.println(result);
		 
	 }

}
