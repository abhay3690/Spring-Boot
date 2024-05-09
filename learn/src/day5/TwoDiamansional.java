package day5;
import java.util.Scanner;

	public class TwoDiamansional{

	    public static void main(String[] args) {
	    	
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the siez of the metrix (n x n): ");
	        int n = scanner.nextInt();

	        int[][] matrixA = new int[n][n];
	        int[][] matrixB = new int[n][n];
	        int[][] sumMatrix = new int[n][n];

	        System.out.println("Enter the elements of the first matrix:");
	        inputMatrixElements(scanner, matrixA);

	        System.out.println("Enter the elements of the second matrix:");
	        inputMatrixElements(scanner, matrixB);

	        // Calculate the sum of matrices
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
	            }
	        }

	        // Print the addition function
	        System.out.println("Addition Function:");
	        printMatrixFunction(matrixA, matrixB, sumMatrix);

	        scanner.close();
	    }
	    

	    // Helper method to input elements of a matrix
	    public static void inputMatrixElements(Scanner scanner, int[][] matrix) {
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
	                matrix[i][j] = scanner.nextInt();
	            }
	        }
	    }

	    // Helper method to print addition function
	    public static void printMatrixFunction(int[][] matrixA, int[][] matrixB, int[][] sumMatrix) {
	        int n = matrixA.length;

	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print("(" + matrixA[i][j] + " + " + matrixB[i][j] + " = " + sumMatrix[i][j] + ") ");
	            }
	            System.out.println();
	        }
	    }
	}

