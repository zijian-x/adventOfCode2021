package day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		var debug = true;
		var path = "resources/day15/" + (debug ? "test" : "input");
		try {
			int[][] grid = Util.convert(Files.readAllLines(Path.of(path)));
			new PartOne().run(grid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
