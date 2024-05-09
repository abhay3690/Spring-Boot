package day7;

class Children {
	String name;
	int roll;

	Children(){
		System.out.println("Constructor called ");
	}
	Children(String name) {
		this.name = name;
	}
	Children(int roll){
		this.roll = roll;
	}
}

public class Non_Parameterised_Constructor{
	public static void main(String[] args) {
		Children s1 = new Children();
		System.out.println(s1);
		Children s2 = new Children(515);
		System.out.println(s2);

		Children s3 = new Children("Abhay");
		System.out.println(s3);

		
	}
}
