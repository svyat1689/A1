/* Svyatoslav Loboda
 * Jan 25, 2018
 * This program will produce the Fibonacci series of numbers output up to a predefined n
 * (input by the user) using recursive and iterative functions.
 * 
 */

//import a simple text scanner
import java.util.Scanner;

public class FibonacciSeriesOfNumbers {

	//--- the main method -----------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter integer number: ");
		int num = reader.nextInt();
		reader.close();
		
		System.out.println("");
		System.out.println("Fibonacci series of numbers using recursive function:");

        //utilizing a variable to get the system time before we execute the recursive factorial method
        long startTimeRec =  System.nanoTime();
        
		for (int i = 0; i < num; i++ ) {
			System.out.print(fiboSeriesRec(i)+" ");
		}
		
        long endTimeRec = System.nanoTime();
        //getting the time it took to run the method by subtracting startTime from endTime.
        
        long timeElapsedRec = endTimeRec-startTimeRec;
        //outputting time elapsed
		
		System.out.println(" \nElapsed time in nanoseconds is: " + timeElapsedRec);
        
		System.out.println("");
		System.out.println("");
		System.out.println("Fibonacci series of numbers using iterative function:");
        //utilizing a variable to get the system time before we execute the recursive factorial method
       
		long startTimeIte =  System.nanoTime();
		
		fiboSeriesIte(num);

        long endTimeIte = System.nanoTime();
        //getting the time it took to run the method by subtracting startTime from endTime.
        
        long timeElapsedIte = endTimeIte-startTimeIte;
        //outputting time elapsed
		
		System.out.println(" \nElapsed time in nanoseconds is: " + timeElapsedIte);
		
		
		System.out.print("Press any key to close the program: ");
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		userInput.close();

	}
	//--- the end of the main method ------------------------------------------------------------------------------
	
	
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
