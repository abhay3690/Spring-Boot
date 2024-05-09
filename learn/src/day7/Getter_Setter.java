package day7;



class Pen1 {
	private int id;
	private String color;
	
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

class Person1 {
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

public class Getter_Setter{
	public static void main(String[] args) {
		Pen1 p = new Pen1();
		p.setId(5);
		p.setColor("rede");
		System.out.println(p.getId());
		p.setId(5);
		System.out.println(p.getColor());
		p.setColor("blue");
		
		
		Person1 p1 = new Person1();
		p1.setName("Abhay");
		p1.name = "G";
		p1.setNumber(602);
		System.out.println(p1.name);
		System.out.println(p1.number);

	}
}
