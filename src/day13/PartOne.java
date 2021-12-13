package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PartOne {

	private enum Axis {
		X, Y
	}

	private int[][] coordinates;
	private int[][] foldInstructions;

	PartOne(List<String> lines) {
		this.coordinates = parseCoordinates(lines);
		this.foldInstructions = parseFoldInstructions(lines);
	}

	void run() {
		int max = Arrays.stream(coordinates)
			.mapToInt(arr -> Math.max(arr[0], arr[1]))
			.max().getAsInt();
		int[][] grid = new int[max + 1][max + 1];
		for (var co : coordinates) {
			int x = co[0];
			int y = co[1];
			grid[x][y] = 1;
		}

		int limitX = grid[0].length;
		int limitY = grid.length;
		for (var instruct : foldInstructions) {
			Axis axis = instruct[0] != 0 ? Axis.X : Axis.Y;
			int location = axis == Axis.X ? instruct[0] : instruct[1];
			fold(grid, axis, location);
			if (axis == Axis.X) {
				limitX = location;
			} else
				limitY = location;
		}

		printGrid(grid, limitX, limitY);
	}

	private void fold(int[][] grid, Axis axis, int location) {
		if (axis == Axis.Y) {
			foldVertical(grid, location);
		} else {
			foldHorizontal(grid, location);
		}
	}

	private void foldVertical(int[][] grid, int location) {
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < location; ++j) {
				if (grid[i][location * 2 - j] == 1) {
					grid[i][location * 2 - j] = 0;
					grid[i][j] = 1;
				}
			}
		}
	}

	private void foldHorizontal(int[][] grid, int location) {
		for (int i = 0; i < location; ++i) {
			for (int j = 0; j < grid[i].length; ++j) {
				if (grid[location * 2 - i][j] == 1) {
					grid[location * 2 - i][j] = 0;
					grid[i][j] = 1;
				}
			}
		}
	}

	private int[][] parseFoldInstructions(List<String> lines) {
		var instructions = lines.stream()
			.filter(s -> s.startsWith("fold"))
			.map(s -> s.replace("fold along ", ""))
			.map(s -> s.split("="))
			.toArray(String[][]::new);
		int[][] foldInstructions = new int[instructions.length][];
		for (int i = 0; i < instructions.length; ++i) {
			int x = 0;
			int y = 0;
			if (instructions[i][0].equals("x"))
				x = Integer.parseInt(instructions[i][1]);
			else
				y = Integer.parseInt(instructions[i][1]);
			foldInstructions[i] = new int[]{x, y};
		}

		return foldInstructions;
	}

	private int[][] parseCoordinates(List<String> lines) {
		List<String> instructions = new ArrayList<>();
		for (var line : lines) {
			if ("".equals(line))
				break;
			instructions.add(line);
		}

		int[][] coordinates = new int[instructions.size()][];
		for (int i = 0; i < instructions.size(); ++i) {
			coordinates[i] = Arrays.stream(instructions.get(i).split(","))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		return coordinates;
	}

	private void printGrid(int[][] grid, int limitX, int limitY) {

		System.out.println("normal layout:");
		for (int i = 0; i < limitY; i++) {
			for (int j = 0; j < limitX; j++) {
				System.out.print(grid[i][j] == 1 ? "# " : ". ");
			}
			System.out.println();
		}

		// rotated layout
		System.out.println("rotated layout:");
		for (int i = 0; i < limitX; ++i) {
			for (int j = 0; j < limitY + 50; ++j) { // hacked my way through it
				System.out.print(grid[j][i] == 1 ? "# " : ". ");
			}
			System.out.println();
		}

	}

}
