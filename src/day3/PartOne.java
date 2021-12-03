package day3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class PartOne {

	PartOne(String path) {
		try (Scanner scanner = new Scanner(new File(path))) {
			run(scanner);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void run(Scanner scanner) {
		String first;
		int[] counter;
		if (scanner.hasNextLine()) {
			first = scanner.nextLine();
			counter = new int[first.length()];
			fillCounter(counter, first);
		} else {
			return;
		}

		while (scanner.hasNextLine()) {
			fillCounter(counter, scanner.nextLine());
		}

		int[] array = new int[counter.length];
		for (int i = 0; i < counter.length; i++) {
			array[i] = counter[i] <= 0 ? 0 : 1;
		}

		int gamma = 0;
		int epsilon = 0;
		int exponent = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 1)
				gamma += Math.pow(2, exponent++);
			else
				epsilon += Math.pow(2, exponent++);
		}

		System.out.println(Arrays.toString(array));
		System.out.println("gamma: " + gamma + ", binary:\t" + Integer.toBinaryString(gamma));
		System.out.println("epsilon: " + epsilon + ", binary:\t0" + Integer.toBinaryString(epsilon));
		System.out.println(gamma * epsilon);
	}

	private void fillCounter(int[] counter, String line) {
		for (int i = 0; i < line.length(); i++) {
			int current = line.charAt(i) - '0';
			counter[i] += (current == 0 ? -1 : 1);
		}
	}
		
}
