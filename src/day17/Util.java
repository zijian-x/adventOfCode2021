package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Util {

	static Point[] getBoundaries(String line) {
		String[] input = Arrays.stream(line.split("\\s"))
			.filter(s -> s.startsWith("x") || s.startsWith("y"))
			.toArray(String[]::new);
		int[][] boundaries = new int[2][2];
		boundaries[0] = getCoordinates(input[0]);
		boundaries[1] = getCoordinates(input[1]);
		for (int i = 0; i < boundaries.length; ++i)
			boundaries[i] = Arrays.stream(boundaries[i])
				.boxed()
				.sorted((i1, i2) -> Integer.compare(Math.abs(i1), Math.abs(i2)))
				.mapToInt(Integer::intValue)
				.toArray();
		var p1 = new Point(boundaries[0][0], boundaries[1][0]);
		var p2 = new Point(boundaries[0][1], boundaries[1][1]);

		return new Point[]{p1, p2};
	}

	private static int[] getCoordinates(String input) {
		int[] coordinates = new int[2];
		int i = 0;
		int n = 0;
		boolean isNegative = false;
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c == '-' && n == 0)
					isNegative = true;
				if (n != 0) {
					coordinates[i++] = isNegative ? n * -1 : n;
					n = 0;
					isNegative = false;
				}
			} else {
				n = n * 10 + Character.getNumericValue(c);
			}
		}
		if (n != 0)
			coordinates[i++] = isNegative ? -n : n;

		return coordinates;
	}

	static List<Point> simulateEndPoint(Point start, Point[] boundaries) {
		List<Point> points = new ArrayList<>();
		int xVel = start.getX();
		int yVel = start.getY();
		var end = new Point(start);

		while (xVel != 0
				|| (end.getX() < boundaries[1].getX() && end.getY() > boundaries[1].getY())) {
			xVel = xVel == 0 ? 0 : xVel < 0 ? xVel + 1 : xVel - 1;
			yVel--;
			end.setX(end.getX() + xVel);
			end.setY(end.getY() + yVel);
			points.add(new Point(end));
		}

		return points;
	}

}
