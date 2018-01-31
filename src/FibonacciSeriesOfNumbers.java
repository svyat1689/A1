/* Svyatoslav Loboda
 * Jan 25, 2018
 * This program outputs Fibonacci series of numbers using recursive and iterative functions.
 * 
 */
import java.util.Scanner;

public class FibonacciSeriesOfNumbers {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter integer number: ");
		int num = reader.nextInt();
		reader.close();
		
		System.out.println("");
		System.out.println("Fibonacci series of numbers using recursive function:");

		
		for (int i = 0; i <= num; i++ ) {
			System.out.print(fiboSeriesRec(i)+" ");
		}
		
		System.out.println("");
		System.out.println("Fibonacci series of numbers using iterative function:");
		System.out.println("");
		
		fiboSeriesIte(num);

	}
	
	public static long fiboSeriesRec(int number) {
		if (number == 0) {
			return 0;
		}
		else if (number == 1) {
			return 1;
		}
		else {
			return fiboSeriesRec(number - 1) + fiboSeriesRec(number - 2);
		}
	}
	
	public static void fiboSeriesIte(int number) {
		long secondLastNum = 0;
		long lastNum = 1;
		for (int i = 0; i <= number; i++) {
			long currentNum = 0;
			if (i == 0) {
				System.out.print(secondLastNum+" ");
			}
			else if (i == 1) {
				System.out.print(lastNum+" ");
			}
			else {
				currentNum = lastNum + secondLastNum;
				System.out.print(currentNum+" ");
				secondLastNum = lastNum;
				lastNum = currentNum;
			}
		}
	}

}
