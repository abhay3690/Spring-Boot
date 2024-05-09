package day8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class Myclass {
	public static void main(String[] args) throws Exception {
		System.out.println("Hii ");
		File f = new File("xyz.txt");
//		BufferedWriter bf = new BufferedWriter(f);
//		f.createNewFile();
//		System.out.println(f.exists());
//		
//		BufferedReader bf = new BufferedReader(f);
//		f.createNewFile();
//		System.out.println(f.exists());
//		FileWriter fw = new FileWriter(f);
//		f.write("Hello How Are You");
//		f.clone();
		FileReader fr = new FileReader(f);
	}

}
