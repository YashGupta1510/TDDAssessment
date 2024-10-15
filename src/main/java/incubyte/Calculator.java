package incubyte;

import java.util.stream.IntStream;

public class Calculator {

	public static int sum(String numbers) {
		int nums[] = splitNumbers(numbers);
		int sum = IntStream.of(nums).sum();
		return sum;
	}

	public static int[] splitNumbers(String numbers) {
		//Return Empty array if string is empty
		if(numbers.isEmpty()) {
			return new int[0];
		}
		
    	//Considers Commas, NewLine, Space as a Delimiter
		String delimiter = ",|\n|\\s";
		
		//Change delimiter if custom delimiter is defined
		if (numbers.startsWith("//")) {
			
			//String between // and \n is the delimiter
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
		return nums;
	}
}
