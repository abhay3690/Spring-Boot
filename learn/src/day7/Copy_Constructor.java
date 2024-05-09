package day7;

class Teacher {
	String name;
	int roll;
	String password;
	int marks[];

	Teacher() {
		marks = new int[3];
		System.out.println("Constructor called ");
	}

	Teacher(String name) {
		marks = new int[3];
		this.name = name;
	}

	Teacher(int roll) {
		marks = new int[3];
		this.roll = roll;
	}
//Shallow copy constructor 
//	Teacher(Teacher s1) {
//		marks = new int[3];
//		this.name = s1.name;
//		this.roll = s1.roll;
//		this.marks =s1.marks;
//	}

//deep copy constructor
	Teacher(Teacher s1) {
		marks = new int[3];
		this.name = s1.name;
		this.roll = s1.roll;
		this.marks = s1.marks;
		for(int i = 0; i < marks.length; i++) {
			this.marks[i] = s1.marks[i];
		}
	}
}

public class Copy_Constructor {
	public static void main(String[] args) {
		Teacher s1 = new Teacher();

		s1.name = "Abhay";
		s1.roll = 52;
		s1.password = "abcd";
		s1.marks[0] = 100;
		s1.marks[1] = 10;
		s1.marks[2] = 1000;

		Teacher s2 = new Teacher(s1);
		s2.password = "safds";
		s1.marks[2] = 152;

		for (int i = 0; i < 3; i++) {
			System.out.println(s2.marks[i]);
		}

	}
}
