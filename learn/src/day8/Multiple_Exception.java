package day8;

public class Multiple_Exception {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		int arr[] = { 25, 96 };
		try {
			System.out.println(arr[3]);

			System.out.println(4 / 0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (ArithmeticException ae) {
			System.out.println(ae);
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

}
