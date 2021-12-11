package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		var path = "resources/day11/input";
		var iteration = 100;
		try {
			int[][] grid = Files.lines(Path.of(path))
				.map(s -> s.chars().map(Character::getNumericValue).toArray())
				.toArray(int[][]::new);
			// new PartOne().run(grid, iteration);
			new PartTwo().run(grid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
