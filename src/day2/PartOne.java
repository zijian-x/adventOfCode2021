package day2;

import java.util.Scanner;

class PartOne {

	private final Scanner scanner;

	PartOne(Scanner scanner) {
		this.scanner = scanner;
		run();
	}

	void run() {
		int x = 0;
		int y = 0;
		while (scanner.hasNextLine()) {
			String[] instruction = scanner.nextLine().split("\\s");
			int val = Integer.parseInt(instruction[1]);
			System.out.println(instruction[0] + ":\t" + val);
			switch (instruction[0]) {
				case "forward":
					x += val;
					break;
				case "up":
					y -= val;
					break;
				case "down":
					y += val;
					break;
			}
		}

		System.out.println("forward: " + x);
		System.out.println("depth: " + y);
		System.out.println("product: " + x * y);
	}
}
