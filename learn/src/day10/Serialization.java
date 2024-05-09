package day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.io.Serializable;



public class Serialization {
	public static void main(String[] args) {

		Student s = new Student("Gaurang", "gaurang@gmail.com", 25, "ahmedabad");

		try {
			// serialization
			FileOutputStream fos = new FileOutputStream("cc");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(s);

			oos.close();
			fos.close();
			System.out.println("state transfer to ob");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
