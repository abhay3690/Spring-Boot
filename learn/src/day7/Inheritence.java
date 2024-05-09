package day7;


	class Animal1 {
	    String name;

	    public Animal1(String name) {
	        this.name = name;
	    }

	    public void eat() {
	        System.out.println(name + " is eating.");
	    }
	}

	// Subclass
	class Dog1 extends Animal1{
	    String breed;

	    public Dog1(String name, String breed) {
	        super(name); // Call superclass constructor
	        this.breed = breed;
	    }

	    public void bark() {
	        System.out.println(name + " is barking.");
	    }
	}

	public class Inheritence {
	    public static void main(String[] args) {
	        // Creating an instance of the subclass Dog
	        Dog1 myDog = new Dog1("Buddy", "Golden Retriever");

	        // Accessing methods from both superclass and subclass
	        myDog.eat();  // Inherited from Animal
	        myDog.bark(); // Defined in Dog class
	    }
	}

