package day8;

import java.io.FileReader;

public class Exception_Handeling {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		FileReader fl;
		try {
//		 fl = new FileReader("abc.txt");
			System.out.println(5 / 0);
		} catch (Exception e) {
//			e.getCause();
		} finally {
			System.out.println("Hii I am finally. ");
		}
	}

}
