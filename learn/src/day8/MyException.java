package day8;

import java.io.FileReader;

public class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}

class g {
	static void pass(int marks) throws MyException {
		if (marks < 30) {
			throw new MyException("Pass");
		}
	}



 public class ThrowException {

 	public static void myFiles() throws Exception {
 		FileReader fl = new FileReader("abc.txt");
 	}

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		// int arr[] = { 356, 5 };
		try {
			g.pass(25);
		} catch (Exception e) {
			System.out.println(e);
		}

//		throw new Exception("Hello World");
//		try {
//		myFiles();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
}
}
