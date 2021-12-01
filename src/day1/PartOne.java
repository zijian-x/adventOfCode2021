package day1;

import java.util.Scanner;

class PartOne {

	private final Scanner scanner;

	PartOne(Scanner scanner) {
		this.scanner = scanner;
	}

	void run() {
		int prev = Integer.MIN_VALUE;
		int count = 0;
		while (scanner.hasNextLine()) {
			int current = Integer.parseInt(scanner.nextLine());
			if (prev != Integer.MIN_VALUE && current > prev) {
				count++;
			}
			prev = current;
		}

		System.out.println(count);
	}

}
