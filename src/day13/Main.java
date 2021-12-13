package day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		var path = "resources/day13/input";
		var test = "resources/day13/test";

		try {
			var lines = Files.readAllLines(Path.of(path));
			new PartOne(lines).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
