package day1;

import java.util.LinkedList;
import java.util.Scanner;

class PartTwo {

	private final Scanner scanner;

	PartTwo(Scanner scanner) {
		this.scanner = scanner;
	}

	void run() {
		LinkedList<Integer> linked = new LinkedList<>();
		int count = 0;
		while (scanner.hasNextLine()) {
			Integer current = Integer.valueOf(scanner.nextLine());
			if (linked.size() < 3) {
				linked.add(current);
				continue;
			}
			if (linked.remove() < current)
				count++;
			linked.add(current);
		}

		System.out.println(count);
	}
}
