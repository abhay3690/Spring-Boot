package day4;

public class Do_While_Example {
		

	public static void main(String[] args) {
		System.out.println("hy");
	    int rows = 5; 

        int i = 1;
        
        do {
          
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
           
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
            i++; 
        } while (i <= rows); 
    }
}



