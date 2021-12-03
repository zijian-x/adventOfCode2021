package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PartTwo {

	PartTwo(String path) {
		try (var reader = Files.newBufferedReader(Path.of(path))) {
			List<String> lines = Files.readAllLines(Path.of(path));
			run(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void run(List<String> lines) {
		Set<String> oxygenSet = new HashSet<>(lines);
		Set<String> co2Set = new HashSet<>(lines);
		int length = lines.get(0).length();
		for (int i = 0; i < length; i++) {
			if (oxygenSet.size() > 1)
				trim(oxygenSet, i, false);
			if (co2Set.size() > 1)
				trim(co2Set, i, true);
		}

		int oxygen = Integer.parseInt(oxygenSet.toString().replaceAll("[\\[\\]]", ""), 2);
		int co2 = Integer.parseInt(co2Set.toString().replaceAll("[\\[\\]]", ""), 2);

		System.out.println(oxygen);
		System.out.println(co2);
		System.out.println(oxygen * co2);
	}

	private void trim(Set<String> set, int i, boolean reverse) {
		char common = getCommon(set, i);
		if (reverse)
			set.removeIf(line -> line.charAt(i) != common);
		else
			set.removeIf(line -> line.charAt(i) == common);
	}

	private char getCommon(Set<String> set, int i) {
		int common = 0;
		for (var line : set) {
			common += line.charAt(i) == '0' ? -1: 1;
		}

		return common < 0 ? '0' : '1';
	}

}
