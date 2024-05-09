package day4;

import java.util.Scanner;

public class Switch_Case {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		switch (day) {
		case 1 -> System.out.println("This is monday");
		case 2 -> System.out.println("This is tuesday");
		case 3 -> System.out.println("This is wed");
		case 4 -> System.out.println("This is thrusday");
		default -> System.out.println("please enter valid input.");
		}
//		Scanner sc = new Scanner(System.in);
////			int day=sc.nextInt();
//		String day = sc.nextLine();
//		String result = "";
//		result = switch (day) {
////			case 1->System.out.println("This is monday");
////			case 2->System.out.println("This is tuesday");
////			case 3->System.out.println("This is wed");
////			case 4->System.out.println("This is thrusday");
////			default-> System.out.println("please enter valid input.");
//		case "Tuesday", "monday":
//			yield "6am";
//		case "saturday":
//			yield "8am";
//		default:
//			yield "9am";
//		};
////			System.out.println(result);
	}
}
