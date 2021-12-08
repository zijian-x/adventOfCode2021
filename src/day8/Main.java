package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String path = "resources/day8/input";
		try {
			List<String> lines = Files.readAllLines(Path.of(path));
			new PartTwo(lines).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
