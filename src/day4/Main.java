package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		String path = "resources/day4/input";
		try {
			List<String> lines = Files.readAllLines(Path.of(path));
			int[] sequence = Arrays.stream(lines.get(0).split(","))
				.mapToInt(Integer::parseInt)
				.toArray();
			int[][][] fields = parseInput(lines);

			// new PartOne(sequence, fields).run();
			new PartTwo(sequence, fields).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[][][] parseInput(List<String> lines) {
		int[][][] fields = new int[getCount(lines)][][];
		int idx = 0;
		for (int i = 1; i < lines.size(); i++) {
			if ("".equals(lines.get(i)))
				continue;
			int[][] field = getField(lines, i);
			fields[idx++] = field;
			i += 4;
		}

		return fields;
	}

	private static int getCount(List<String> lines) {
		int count = 0;
		for (var line : lines) {
			if ("".equals(line))
				count++;
		}

		return count;
	}

	private static int[][] getField(List<String> lines, int index) {
		int[][] field = new int[5][5];
		for (int i = 0; i < field.length; i++) {
			String[] row = lines.get(i + index).strip().split("\\s+");
			for (int j = 0; j < row.length; j++) {
				field[i][j] = Integer.parseInt(row[j]);
			}
		}

		return field;
	}

}
