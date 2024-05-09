package day6;

import java.util.*;

class Circle {
	double radius;

	double circumference() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Radius R : ");
		double r = sc.nextInt();
		double circum = 2 * 3.14 * r;
		return circum;
	}
}

public class Method_Without_Parameter {
	public static void main(String args[]) {
		Circle c = new Circle();
		double circum;

		circum = c.circumference();
		System.out.println("Circumference of circle is : " + circum);
	}
}
