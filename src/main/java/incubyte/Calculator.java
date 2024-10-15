package incubyte;

import java.util.stream.IntStream;

public class Calculator {

	public static int sum(String numbers) {
		int nums[] = splitNumbers(numbers);
		int sum = IntStream.of(nums).sum();
		return sum;
	}

	public static int[] splitNumbers(String numbers) {
		if(numbers.isEmpty()) {
			return new int[1];
		}
		String tokens[] = numbers.split(",|\n");
		int nums[] = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			nums[i] = Integer.parseInt(tokens[i]);
		}
		return nums;
	}

}
