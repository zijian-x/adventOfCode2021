package day5;

import java.util.Arrays;
import java.util.List;

class Util {

	private final List<String> lines;

	Util(List<String> lines) {
		this.lines = lines;
	}

	int[][] getSegments() {
		int[][] segments = new int[lines.size()][4];
		// 234,234 -> 232,523
		for (int i = 0; i < segments.length; i++) {
			segments[i] = Arrays.stream(lines.get(i).replace(" -> ", ",").split(","))
				.mapToInt(Integer::parseInt).toArray();
		}

		return segments;
	}

	int getMaxVal(int[][] segments) {
		return Arrays.stream(segments).flatMapToInt(Arrays::stream).max().orElse(-1);
	}

	void mapVertical(int[][] coordinates, int[] segment) {
		int x = segment[0];
		int y = Math.min(segment[1], segment[3]);
		int dy = Math.abs(segment[1] - segment[3]);
		for (int i = y; i <= y + dy; i++)
			coordinates[x][i]++;
	}

	void mapHorizontal(int[][] coordinates, int[] segment) {
		int x = Math.min(segment[0], segment[2]);
		int y = segment[1];
		int dx= Math.abs(segment[0] - segment[2]);
		for (int i = x; i <= x + dx; i++)
			coordinates[i][y]++;
	}

	void mapDiagonal(int[][] coordinates, int[] segment) {
		int x = segment[0];
		int y = segment[1];
		int dx = segment[0] - segment[2];
		int dy = segment[1] - segment[3];
		if (Math.abs(dx) != Math.abs(dy))
			throw new IllegalStateException();
		for (int i = 0; i <= Math.abs(dx); i++) {
			int offsetX = dx < 0 ? i : -i;
			int offsetY = dy < 0 ? i : -i;
			coordinates[x + offsetX][y + offsetY]++;
		}
	}

}
