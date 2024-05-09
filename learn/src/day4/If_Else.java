package day4;
import java.util.Scanner;

public class If_Else {
	public static void main(String []args) {
		int i;
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		if(i<5) {
			System.out.println("Yoar age is Baby");
		}
		else if(i<12) {
			System.out.println("Your age is Children");
		}
		else if(i<18) {
			System.out.println("Your age is Younger");
		}
		else if(i<60) {
			System.out.println("Your age is Adult");
		}
		else if(i>60) {
			System.out.println("Your age is Elder");
		}
		else System.out.println("You are by Deafaut");
	}
}
