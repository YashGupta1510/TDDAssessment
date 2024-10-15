package incubyte;

import java.util.stream.IntStream;

public class Calculator {

	public static int sum(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} else {
			int nums[] = splitNumbers(numbers);
			int sum = IntStream.of(nums).sum();
			return sum;
		}
	}

	public static int[] splitNumbers(String numbers) {

		String tokens[] = numbers.split(",");
		int nums[] = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			nums[i] = Integer.parseInt(tokens[i]);
		}

		return nums;

	}

}
