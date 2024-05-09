package day5;

import java.util.Scanner;

public class ReverseArray1 {
	public static void reverseNumbers(int number[]) {
		int start =0,end = number.length-1;
		while(start<end) {
			number[start] = number[start]+number[end];
			number[end] = number[start]-number[end];
			number[end] = number[end]-number[start]; 
			start++;
			end--;
			
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int number[] = new int [a];
		for (int i = 0; i<a; i++) {
			number[i] =sc.nextInt();
		}
		reverseNumbers(number);
		for(int i=0;i<number.length;i++) {
			System.out.println(number[i]);
		}
	}

}
