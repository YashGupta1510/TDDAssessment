package incubyte;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

	/*
	 * The Function sum takes a string of numbers as input and returns the sum as
	 * the result.
	 * 
	 * Step 1: Check for an Empty string Step 2: Set the Delimiter Step 3: Split the
	 * String into Tokens and Convert it into valid integers Step 4: Return the
	 * total sum
	 * 
	 */

	public static int sum(String numbers) {
		int nums[] = splitNumbers(numbers);
		int sum = IntStream.of(nums).sum();
		return sum;
	}

	public static int[] splitNumbers(String numbers) {
		// Return Empty array if string is empty
		if (numbers.isEmpty()) {
			return new int[0];
		}

		// Considers Commas, NewLine, Space as a Delimiter
		String delimiter = ",|\n|\\s";

		// Change delimiter if custom delimiter is defined
		if (numbers.startsWith("//")) {

			// String between // and \n is the delimiter
			int delimiterEndIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(2, delimiterEndIndex);
			numbers = numbers.substring(delimiterEndIndex + 1);
		}

		String tokens[] = numbers.split(delimiter);
		int nums[] = convert(tokens);

		return nums;
	}

	public static int[] convert(String[] tokens) {
		int nums[] = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			nums[i] = Integer.parseInt(tokens[i]);
		}
		validateNums(nums);
		return nums;
	}

	public static void validateNums(int[] nums) {
		String negatives = "";
		//Filter Stream to indentify negatives, converted to Strings and joined to output string
		IntStream.of(nums).filter(num -> num < 0)
							.boxed().map(String::valueOf)
							.collect(Collectors.joining(","));
		if(!negatives.isEmpty()) {
			throw new RuntimeException("Negative numbers not allowed " + negatives);
		}
	}
}
