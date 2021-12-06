package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		try {
			String path = "resources/day6/input";
			String line = Files.readString(Path.of(path)).strip();
			int[] fishes = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
			new PartOne(fishes, 256).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
