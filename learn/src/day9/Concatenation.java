package day9;


public class Concatenation {
	public static void printletters(String str) {
		for(int i=0;i<str.length();i++) {
			System.out.println(str.charAt(i)+" ");
		}
	}
	public static boolean isPalindome(String str) {
		for(int i=0;i<str.length()/2;i++) {
			int n = str.length();
			if(str.charAt(i)!=str.charAt(n-1-i)) {
				return false;
			}
		}
		return true;
	}
public static void main(String[] args) {
	String Fname = "Dog";
	String Lname = "Animal";
	String FullName = Fname + " "  +Lname;  
	System.out.println(FullName.charAt(3));
	printletters(FullName);
	System.out.println(isPalindome(Lname));
}
}
  