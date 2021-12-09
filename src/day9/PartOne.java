package day9;

import java.util.List;

class PartOne {

	private final List<String> lines;

	PartOne(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		int[][] field = Util.getField(lines);

		int risky = 0;
		for (int i = 0; i < field.length; ++i) {
			for (int j = 0; j < field[i].length; ++j) {
				if (Util.isDent(field, i, j))
					risky += 1 + field[i][j];
			}
		}

		System.out.println(risky);
	}

}
