package day4;

public class Do_While_Example2 {
	public static void main(String[] args) {
		int rows = 5;

		int i = 1;
		do {

			int spaces = Math.abs(rows / 2 - i + 1);
			do {
				System.out.print(" ");
				spaces--;
			} while (spaces > 0);

			int stars = rows - 2 * Math.abs(rows / 2 - i + 1);
			do {
				System.out.print("*");
				stars--;
			} while (stars > 0);

			System.out.println();
			i++;
		} while (i <= rows);

		i = rows - 1;
		do {
			int spaces = Math.abs(rows / 2 - i + 1);
			do {
				System.out.print(" ");
				spaces--;
			} while (spaces > 0);

			int stars = rows - 2 * Math.abs(rows / 2 - i + 1);
			do {
				System.out.print("*");
				stars--;
			} while (stars > 0);

			System.out.println();
			i--;
		} while (i > 0);
	}
}
