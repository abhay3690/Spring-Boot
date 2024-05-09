package day7;
import java.util.*;
class Bicycle {
	
	public int gear;
	public int speed;
	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
	}
	public void applyBrake(int decrement) {
		speed -= decrement;
	}
	public void speedUp(int increment) {
		speed += increment;
	}
	public String toString() {
		return ("No of gears are " + gear + "\n" + "speed of bicycle is " + speed);
	}
}


class MountainBike extends Bicycle {
	public int seatHeight;
	public MountainBike(int gear, int speed, int startHeight) {
		super(gear, speed);
		seatHeight = startHeight;
	}
	public void setHeight(int newValue) {
		seatHeight = newValue;
	}
	@Override
	public String toString() {
		return (super.toString() + "\nseat height is " + seatHeight);
	}
}


public class Hiereechical_Inheritence {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number of A :");
		int a =sc.nextInt();
		System.out.println("Enter a number of B :");
		int c =sc.nextInt();
		System.out.println("Enter a number of C :");
		int b =sc.nextInt();
		MountainBike mb = new MountainBike(a, 100, 25);
		System.out.println(mb.toString());
	}
}
