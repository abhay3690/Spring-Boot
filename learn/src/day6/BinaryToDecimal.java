package day6;

import java.util.Scanner;
public class BinaryToDecimal {
	public static void BinToDec(int binNum){
		int pow = 0;
		int dec=0;
		while(binNum>0) {
			int lastdigit = binNum % 10;
			dec = dec +(lastdigit *(int)Math.pow(2, pow));
			pow++;
			binNum = binNum / 10;
			BinToDec(binNum);
		}System.out.println(dec);
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a = sc.nextInt();
		BinToDec(a);
	}

}
