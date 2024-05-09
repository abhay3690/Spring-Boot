package day7;

class Animala {
	public void makeSound() {
		System.out.println("Animal makes a sound");
	}
}

class Dogee extends Animala {
	
	public void makeSound() {
		System.out.println("Dog barks");
	}
}

public class Polymorphism_OverRide {
	public static void main(String[] args) {
		Animala animal = new Animala();
		animal.makeSound();

		Dogee dog = new Dogee();
		dog.makeSound(); 
	}
}
