package day15;

import java.util.List;

class Util {

	static int[][] convert(List<String> lines) {
		return lines.stream()
			.map(l -> l.chars().map(Character::getNumericValue).toArray())
			.toArray(int[][]::new);
	}

}
