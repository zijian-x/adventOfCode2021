package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String path = "resources/day5/input";
		try {
			List<String> lines = Files.readAllLines(Path.of(path));
			Util utils = new Util(lines);
			// new PartOne(utils).run();
			new PartTwo(utils).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
