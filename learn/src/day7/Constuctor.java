package day7;

class Student {
	String name;
	int roll;

	Student() {
//		this.name = name;
		System.out.println("Constructor is called ");
	}
}

public class Constuctor {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1.name);
	}
}
