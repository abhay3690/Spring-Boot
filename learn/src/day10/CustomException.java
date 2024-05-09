package day10;

class AbhayException extends Exception{
	public AbhayException(String string) {
		super(string);
	}
}

public class CustomException {
public static void main(String[] args) {
	int i = 20;
	int j = 0;
	try {
		j = 18/i;
		if(j==0) {
			throw new AbhayException("Hii There ");
		}
	}catch(ArithmeticException e) {
		j=18/1;
		System.out.println("This is ArithmeticException : "+e);
	}catch(Exception e) {
		System.out.println("Something Went wrong "+e);
	}
}
}
