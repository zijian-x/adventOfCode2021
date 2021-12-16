package day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		test();
		start();
	}

	private static void test() {
	}

	private static void start() {
		var debug = false;
		var path = "resources/day16/" + (debug ? "test2" : "input");

		try {
			var lines = Files.readAllLines(Path.of(path));
			for (var line : lines) {
				System.out.println("=============================================");
				String hex = Util.parseHexToBinary(line);
				// new PartOne(hex).run();
				new PartTwo(hex).run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
