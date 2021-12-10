package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PartTwo {

	private final List<String> lines;

	PartTwo(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		List<Long> scores = new ArrayList<>();
		for (var line : lines) {
			long score = Util.getCompletionScore(line);
			if (score != 0)
				scores.add(score);
		}
		Collections.sort(scores);

		for (var score : scores)
			System.out.println(score);
		System.out.println(scores.get(scores.size() / 2));
	}

}
