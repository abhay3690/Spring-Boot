package day7;

class Pen {
	int id;
	String color;
	
	int getId() {
		return this.id;
	}
	String getColor() {
		return this.color;
	}
	void setId(int newId) {
		this.id = newId;
	}

	void setColor(String newColor) {
		this.color = newColor;
	}
}

class Person {
	int number;
	String name;
	int getNumber() {
		return this.number;
	}

	void setNumber(int newNumber) {
		this.number = newNumber;
	}

	void setName(String newName) {
		this.name = newName;
	}
}

public class Class_Objects {
	public static void main(String[] args) {
		Pen p = new Pen();
		
		p.setId(5);
		p.setColor("Blue");
		System.out.println(p.id);
		System.out.println(p.color);
		
		Person p1 = new Person();
		
		p1.setName("Abhay");
		
		System.out.println(p1.name);
		
		p1.setNumber(602);
		System.out.println(p1.number);

	}
}
