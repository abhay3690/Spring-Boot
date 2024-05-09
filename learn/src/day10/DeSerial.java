package day10;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
 
public class DeSerial {
	public static void main(String[] args) {
		// de-serialization
				
				try {
					FileInputStream	fis = new FileInputStream("cc");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Student stud = (Student) ois.readObject();
				
					stud.displayNmae();
					System.out.println(stud.getName()+" "+stud.getEmail()+" "+stud.getAddress()+" "+stud.getAge());
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}
}