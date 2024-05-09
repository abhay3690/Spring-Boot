package day7;

import java.util.*;

abstract class Animals {

	void eat() {
		System.out.println("It can be eat");
	}

	abstract void walk();
}

class Wizzard extends Animals {

	void leg() {
		System.out.println("It will running on own leg's ");
	}

	void walk() {
		System.out.println("Wizzard can have a 4 leg's ");
	}
}

class Wizz extends Animals {

	void leg() {
		System.out.println("It will running on own leg's ");
	}

	void walk() {
		System.out.println("Wizzard can have a 4 leg's ");
	}
}

public class Abstraction {
	public static void main(String[] args) {
		Wizzard w = new Wizzard();
		w.walk();
		Wizz w1 = new Wizz();
		w1.walk();
	}
}
