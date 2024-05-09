package day5;

import java.nio.file.spi.FileSystemProvider;
import java.util.Random;

public class Array1 {
	public static void Array(int marks[],int nonChangable) {
		nonChangable = 10;
		for (int i=0;i<marks.length;i++) {
			marks[i] = marks[i] + 1;
			System.out.print(marks[i] +" ");
		}
		System.out.println();
	}
public static void main(String[] args) {
	int marks[] = {98,66,45};
	int nonChangable = 5; 
	Array(marks,nonChangable);
	
	System.out.println(nonChangable);
//	for (int i =0; i<marks.length; i++) {
//		System.out.println(marks[i]);
//	}
	System.out.println();
	Random rm = new Random();
	int a = rm.nextInt();
	System.out.println(a);
}
}
