package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		var path = "resources/day12/input";
		var testPath = "resources/day12/test";
		try {
			var lines = Files.readAllLines(Path.of(path));
			var test = test(testPath);
			new PartOne(test).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> test(String path) {
		List<String> mapped = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Path.of(path));
			Map<String, String> map = new HashMap<>();
			map.put("dc", "d");
			map.put("HN", "H");
			map.put("kj", "k");
			map.put("LN", "l");
			map.put("sa", "s");
			for (var line : lines) {
				var items = map.keySet().stream().filter(s -> line.contains(s)).toArray(String[]::new);
				String newLine = line;
				for (var s : items)
					newLine = newLine.replaceAll(s, map.get(s));
				mapped.add(newLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mapped;
	}

}
