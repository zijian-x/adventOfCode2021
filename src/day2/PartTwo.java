package day2;

import java.util.Scanner;

class PartTwo {

	private final Scanner scanner;

	PartTwo(Scanner scanner) {
		this.scanner = scanner;
	}

	void run() {
		int aim, x, y;
		aim = x = y = 0;
		while (scanner.hasNextLine()) {
			String[] command = scanner.nextLine().split("\\s");
			int val = Integer.parseInt(command[1]);
			switch (command[0]) {
				case "forward":
					x += val;
					y += aim * val;
					break;
				case "down":
					aim += val;
					break;
				case "up":
					aim -= val;
					break;
			}
		}

		System.out.println(x * y);
	}

}
