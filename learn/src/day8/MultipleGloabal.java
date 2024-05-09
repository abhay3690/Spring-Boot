package day8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MultipleGloabal {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		int arr[] = { 356, 5 };
		Scanner sc = new Scanner(System.in);
		try (sc; FileReader fl = new FileReader("abc.txt"); BufferedReader bf = new BufferedReader(fl);) {
			String line;

			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}

			// System.out.println(4/0);
			System.out.println(arr[63]);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
