package day7;

class Animal {
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
    	System.out.println("data passed through constructor");
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Child class (subclass)
class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Call to superclass constructor
        this.breed = breed;
    }

    // Getter method
    public String getBreed() {
        return breed;
    }

    // Method to display information (overrides the displayInfo method in the superclass)
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

public class Inheritence_Constructor {
    public static void main(String[] args) {
    
        Dog dog1 = new Dog("Buddy", 5, "Golden Retriever");

    
        System.out.println("Dog Information:");
        dog1.displayInfo();
    }
}