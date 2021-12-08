package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		try {
			String path = "resources/day7/input";
			String line = Files.readString(Path.of(path));
			int[] pos = Arrays.stream(line.strip().split(","))
				.mapToInt(Integer::parseInt)
				.toArray();
			// new PartOne(pos).run();
			new PartTwo(pos).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
