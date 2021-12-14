package day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		var input = "resources/day14/input";
		var test = "resources/day14/test";
		var debug = false;

		try {
			var lines = Files.readAllLines(Path.of(debug ? test : input));
			// new PartOne(lines).run(); // brute force
			new PartTwo(lines).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
