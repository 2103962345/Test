package Hundred;
import java.math.BigInteger;

public class Hundred {
	//Get the result of 100!
	public static BigInteger getFactorial(int n) {
		//BigInteger class to work with large numbers.
		//BigInteger factorial stores the factorial of the number.
		BigInteger factorial = BigInteger.ONE;
		 // Calculate the factorial of a given number
		for (int i = 1; i <= n; i++) {
			// Use BigInteger methods to multiply all numbers
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
}

	//Find the sum of digits of 100!.
public static void sumOfDigits(String s) {
	// sum stores the sum of digits of 100!.
	int sum = 0;
	//iterate all digits of number
	for (int i = 0; i < s.length(); i++) {
		//get every digit and sum it
		sum += Integer.parseInt(s.substring(i, i + 1));
	}
	// Print the result
	System.out.println(sum);
}

	public static void main(String[] args) {
		// Call the method
		sumOfDigits(getFactorial(100).toString());
	}

}
