package day10;

import java.util.List;

class PartOne {

	private final List<String> lines;

	PartOne(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		int sum = 0;
		for (var line : lines) {
			sum += Util.getCorruptScore(line);
		}

		System.out.println(sum);
	}

}
