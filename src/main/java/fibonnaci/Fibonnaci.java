package fibonnaci;

import java.time.Duration;
import java.time.Instant;

/**
 * this class solves the Fibonacci numbers three ways.  Loop, Memorization, and recursive.
 * 
 * @author bgoff
 * @since 23 Aug 2024
 */
public class Fibonnaci {

	static int fibMemo[];
	
	/**
	 * Fibonnaci by Recursive Memorization.
	 * 
	 * @param num
	 * @return
	 */
	public static int fibonnaciByRecursiveMemorization(int num)
	{
		if(num == 0) {
			fibMemo[0] = 0;
			return 0;
		}

		if(num ==1 || num ==2) {
			fibMemo[num] = 1;
			return 1; 
		}

		if(fibMemo[num] == 0) {
			fibMemo[num] = fibonnaciByRecursiveMemorization(num-1) + fibonnaciByRecursiveMemorization(num -2);
			return fibMemo[num];
		} else {
			return fibMemo[num];
		}
    }
    
	/**
	 * Fibonnaci by Recursion.
	 * 
	 * @param num
	 * @return
	 */
	public static int[] fibonnaciByRecursion(int num) {
		int fib[] = new int[num];

		for (int i = 0; i < num; i++) {
			fib[i] = fibonnaciRecursion(i);
		}

		return fib;
    }

	public static int fibonnaciRecursion(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1 || num == 2) {
			return 1;
		} else {
			return fibonnaciRecursion(num - 1) + fibonnaciRecursion(num - 2);
		}
	}

	/**
	 * Fibonnaci by "For Loop".
	 * 
	 * @param num
	 * @return
	 */
	public static int[] fibonnaciForLoop(int num) {
		int fibSum[] = new int[num];
		for (int i = 0; i < num; i++) {
			if (i == 0) {
				fibSum[i] = i;
				continue;
			}

			if (i == 1 || i == 2) {
				fibSum[i] = 1;
				continue;
			}

			fibSum[i] = fibSum[i - 1] + fibSum[i - 2];
		}
		return fibSum;
	}
	
	/**
	 * method used to make a duration human readable.
	 * @param duration Duration to make human readable.
	 * @return String Duration in a human readable form.
	 */
	public static String formatDuration(Duration duration) {
		return duration.toString()
	            .substring(2)
	            .replaceAll("(\\d[HMS])(?!$)", "$1 ")
	            .toLowerCase();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) 
	{
		int num = 20;

		System.out.println("By For Loop");
		Instant startTimeForLoop = Instant.now();
		//Long startTimeForLoop = System.nanoTime();
		// returns the fib series
		int fibSeries[] = fibonnaciForLoop(num);
		for (int i = 0; i < fibSeries.length; i++) {
			System.out.print(" " + fibSeries[i] + " ");
		}
		Instant stopTimeForLoop = Instant.now();
		//Long stopTimeForLoop = System.nanoTime();

		System.out.println("");
		System.out.println("For Loop Time:  " + formatDuration(Duration.between(startTimeForLoop, stopTimeForLoop)));
		
		System.out.println("\n\nBy Using Recursion");
		Instant startTimeRecursion = Instant.now();
//		Long startTimeRecursion = System.nanoTime();
		// uses recursion
		int fibSeriesRec[] = fibonnaciByRecursion(num);

		for (int i = 0; i < fibSeriesRec.length; i++) {
			System.out.print(" " + fibSeriesRec[i] + " ");
		}
		Instant stopTimeRecursion = Instant.now();
//		Long stopTimeRecursion = System.nanoTime();
		System.out.println("");
		System.out.println("Recursion Time:  " + formatDuration(Duration.between(startTimeRecursion, stopTimeRecursion)));

		System.out.println("\n\nBy Using Memorization Technique");
		Instant startTimeMemo = Instant.now();
//		Long startTimeMemo = System.nanoTime();
		// uses memorization
		fibMemo = new int[num];
		fibonnaciByRecursiveMemorization(num-1);
		for (int i = 0; i < fibMemo.length; i++) {
			System.out.print(" " + fibMemo[i] + " ");
		}
		Instant stopTimeMemo = Instant.now();
//		Long stopTimeMemo = System.nanoTime();
		System.out.println("");
		System.out.println("Memoization Time:  " + formatDuration(Duration.between(startTimeMemo, stopTimeMemo)));
	}
}
