package day4;

public class Break_Continue_Example {
	public static void continue1(int l) {
		for (int i = 1; i < l; i++) {
			if (i == 2) {
				continue;
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			if (i == 3) {
				break;
			}
			System.out.println("Number is " + i);
		}
		int n = 7;
		continue1(n);
	}

}
