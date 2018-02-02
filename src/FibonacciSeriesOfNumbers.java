/* Svyatoslav Loboda
 * Jan 25, 2018
 * This program will produce the Fibonacci series of numbers output up to a predefined n-th number
 * (input by the user) using recursive and iterative functions.
 * This program also utilizes Java timing library to time the run time of recursive and iterative
 * methods that produce Fibonacci series of numbers and it outputs execution times in both
 * nano- and milliseconds.
 */

//import a simple text scanner
import java.util.Scanner;

public class FibonacciSeriesOfNumbers {

	//--- the main method -----------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		System.out.println("\n FIBONACCI SERIES OF NUMBERS");
		System.out.println(" ---------------------------");
		
		//user defined input of n-th number for generating Fibonacci series of numbers
		boolean isInteger = false; //variable to test user input
		int num = 0; //variable to hold user input
		
		Scanner userInputNum = new Scanner(System.in);
		System.out.print("\n Enter a positive integer number: ");
		//we accept the user's input and check if it is a positive integer; if not we ask the user to re-enter an integer
		do {		
			String s = userInputNum.nextLine();
			if (s.trim().isEmpty()) { //if the user entered a white space 
				isInteger = false;
				System.out.print(" Enter a positive integer number: ");
			} else {
				try {
					num = Integer.parseInt(s.trim());
					if (num > 0) { //if the user entered positive integer
						isInteger = true;
						} else { //if the user entered negative integer or zero
							isInteger = false;
							System.out.print(" Enter a positive integer number: ");
							}
					} catch (NumberFormatException nfe) {
						System.out.print(" Enter a positive integer number: ");
						}
			}
			
		} while (!isInteger);
		userInputNum.close();
		
		//--Recursive function output--
		System.out.println("\n Fibonacci series of numbers up to the " +  num + "-th number including, using recursive function:");
		System.out.print(" ");

		// !!! - I used lecture materials for the timer code - !!!
        //start the timer
        long startTimeRec =  System.nanoTime();
        //run the recursive function
		for (int i = 0; i < num; i++ ) {
			System.out.print(fiboSeriesRec(i)+" ");
		}
		//stop the timer
        long endTimeRec = System.nanoTime();
        //compute time elapsed
        long timeElapsedRec = endTimeRec - startTimeRec;
        //outputting time elapsed
		System.out.println(" \n Elapsed time in nanoseconds is: " + timeElapsedRec);
		System.out.println(" Elapsed time in milliseconds is: " + timeElapsedRec/1000000 + "." + timeElapsedRec%1000000);
		
		//--Iterative function output--
		System.out.println("\n Fibonacci series of numbers up to the " +  num + "-th number including, using iterative function:");
		System.out.print(" ");
		//start the timer
		long startTimeIte =  System.nanoTime();
		//run the iterative function
		fiboSeriesIte(num);
		//stop the timer
        long endTimeIte = System.nanoTime();
        //compute the time elapsed
        long timeElapsedIte = endTimeIte - startTimeIte;
        //outputting time elapsed
		System.out.println(" \n Elapsed time in nanoseconds is: " + timeElapsedIte);
		System.out.println(" Elapsed time in milliseconds is: " + timeElapsedIte/1000000 + "." + timeElapsedIte%1000000);
		
	}
	//--- the end of the main method ------------------------------------------------------------------------------
	
	//Fibonacci series - Recursive method
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
	//Fibonacci series - Iterative method
	public static void fiboSeriesIte(int number) {
		long secondLastNum = 0;
		long lastNum = 1;
		for (int i = 0; i < number; i++) {
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
