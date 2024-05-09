package day5;

public class LinearSearch {
	public static int linearSearch(int marks[], int key) {
//		for(int i = 0; i <= marks.length-1; i++)
		for (int i = 0; i < marks.length; i++) {
			if (marks[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int marks[] = { 5, 85, 47, 1, 885, 98, 41 };
		int key = 855;
		int index = linearSearch(marks, key);

		if (index == -1) {
			System.out.println("Out of the length");
		} else {
			System.out.println("InIndex" + index);
		}

	}

}
