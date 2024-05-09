package day2;

class Person{
	String name;
	int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age ;
	}
}
public class refernce_dataTypes {
	public static void main(String[] args) {
		Person p = new Person("abhay",52);
		System.out.println(p);
	}
}
