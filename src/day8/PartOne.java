package day8;

import java.util.List;
import java.util.Set;

class PartOne {

	private final List<String> lines;

	PartOne(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		int counter = 0;
		Set<Integer> set = Set.of(2, 3, 4, 7);
		for (var line : lines) {
			line = line.replaceFirst(".*\\s\\|\\s", "");
			for (var pattern : line.split("\\s")) {
				if (set.contains(pattern.length()))
					counter++;
			}
		}

		System.out.println(counter);
	}

}
