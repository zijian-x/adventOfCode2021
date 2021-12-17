package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		var debug = true;
		var path = "resources/day17/" + (debug? "test" : "input");
		try {
			var line = Files.readAllLines(Path.of(path)).get(0);
			Point[] boundaries = Util.getBoundaries(line);
			new PartOne(boundaries).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
