
/**
 * Write an exception class named InvalidTestScore. 
 * Modify the TestScores class you wrote in the previous exercise so that 
 * it throws an InvalidTestScore exception if any of the test scores in the array are invalid.
 * Test your exception in a program (in a Driver class located in the same file). 
 * Your program should prompt the user to enter the number of test scores, and then ask for each test score individually.
 * Then, it should print the average of the test scores.
 * If the average method throws an InvalidTestScore exception, the main method should catch it and print “Invalid test score.”
 * Sample Run
 * java Driver
 * Enter·number·of·test·scores:5↵
 * Enter·test·score·1:70↵
 * Enter·test·score·2:65↵
 * Enter·test·score·3:94↵
 * Enter·test·score·4:55↵
 * Enter·test·score·5:90↵
 * 74.8↵
 * 
 * @author Mark Kasule
 */
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws InvalidTestScore {

		Scanner input = new Scanner(System.in);

		// ask user for size
		System.out.print("Enter number of test scores:");
		int testSize = input.nextInt();

		// create an array object
		double[] testArray = new double[testSize];
		TestScores newArray;
		double element;

		for (int i = 0; i < testArray.length; i++) {
			System.out.print("Enter test score " + (i + 1) + ": ");
			element = input.nextDouble();
			testArray[i] = element;

			// send scores into an array and check for errors
			try {
				// create array to hold values
				newArray = new TestScores(testArray);
				// return average if all is good
			} catch (InvalidTestScore ex) {
				System.out.println(ex.getMessage());
				System.exit(0);
			}
		}
		// print results
		newArray = new TestScores(testArray);
		System.out.println(newArray.average(testSize));

	}
}

/**
 * class calculates average
 * 
 * @author Mark Kasule
 *
 */
class TestScores {

	private double[] scores;
	// track total
	private double total = 0;

	/**
	 * throw exception through constructor
	 * 
	 * @param scores
	 * @throws InvalidTestScore
	 */
	public TestScores(double[] scores) throws InvalidTestScore {

		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= 0 && scores[i] <= 100) {
				total += scores[i];
			} else {
				throw new InvalidTestScore("Invalid test score.");
			}
		}

	}

	/**
	 * calculate average
	 * 
	 * @param size
	 * @return
	 */
	public double average(int size) {

		return (total / size);
	}
}

class InvalidTestScore extends Exception {
	public InvalidTestScore(String result) {
		super(result);
	}
}
