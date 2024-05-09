package day2;
import java.util.Scanner; 

public class variables_and_Constants {
	public static void main(String[] args) {
		int radius;
		double pi = 3.14;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a radius : ");
		radius = sc.nextInt();
		double area = pi*radius*radius;
		System.out.println(area);
		
		
	}
}
