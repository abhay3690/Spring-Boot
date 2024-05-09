package day7;

class Overload{
	int sum(int a, int b){
		return a+b;
	}
	float sum(float a, float b, float c){
		return a+b+c;
	}
	int sum(int a, int b, int c, int d){
		return a+b+c+d;
	}
}
public class Polymorphism_Overload {
public static void main(String[] args) {
	Overload o = new Overload();
	System.out.println(o.sum(1, 3));
	System.out.println(o.sum(1.53f, 3.8f,9.89f));
	System.out.println(o.sum(1, 3, 5, 76));
}
}
