package day5;

class PartOne {

	private final Util utils;

	PartOne(Util utils) {
		this.utils = utils;
	}

	void run() {
		int[][] segments = utils.getSegments();
		int max = utils.getMaxVal(segments) + 1;
		int[][] coordinates = new int[max][max];
		for (var segment : segments) {
			if (segment[0] != segment[2] && segment[1] != segment[3])
				continue;
			if (segment[0] == segment[2]) {
				utils.mapVertical(coordinates, segment);
			} else if (segment[1] == segment[3]) {
				utils.mapHorizontal(coordinates, segment);
			}
		}

		int count = countOverlap(coordinates);
		System.out.println(count);
	}

	private int countOverlap(int[][] coordinates) {
		int count = 0;
		for (var row : coordinates) {
			for (var coordinate : row) {
				if (coordinate > 1)
					count++;
			}
		}

		return count;
	}

}
