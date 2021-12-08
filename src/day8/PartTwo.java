package day8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PartTwo {

	private final List<String> lines;
	private Set<Character> set1 = new HashSet<>();
	private Set<Character> set2 = new HashSet<>();
	private Set<Character> set3 = new HashSet<>();
	private Set<Character> set4 = new HashSet<>();
	private Map<Set<Character>, Integer> setmap = new HashMap<>();

	PartTwo(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		int sum = 0;
		for (var line : lines) {
			fillSets(line);
			fillMap(line);
			sum += getLineSum(line);
			clear();
		}

		System.out.println(sum);
	}

	private int getLineSum(String line) {
		String[] patterns = line.replaceFirst(".*\\s\\|\\s", "").split("\\s");
		int[] digits = Arrays.stream(patterns).mapToInt(this::getDigit).toArray();

		int sum = Arrays.stream(digits).reduce(0, (a, b) -> a * 10 + b);
		return sum;
	}

	private int getDigit(String pattern) {
		Set<Character> set = new HashSet<>();
		for (char c : pattern.toCharArray())
			set.add(c);
		for (var entry : setmap.entrySet()) {
			if (set.equals(entry.getKey()))
				return entry.getValue();
		}

		return -1;
	}

	private void fillMap(String line) {
		Map<int[], Integer> map = new HashMap<>();
		map.put(new int[]{2, 1, 1, 2}, 0);
		map.put(new int[]{2, 0, 0, 0}, 1);
		map.put(new int[]{1, 1, 1, 2}, 2);
		map.put(new int[]{2, 1, 1, 1}, 3);
		map.put(new int[]{2, 0, 2, 0}, 4);
		map.put(new int[]{1, 1, 2, 1}, 5);
		map.put(new int[]{1, 1, 2, 2}, 6);
		map.put(new int[]{2, 1, 0, 0}, 7);
		map.put(new int[]{2, 1, 2, 2}, 8);
		map.put(new int[]{2, 1, 2, 1}, 9);

		String[] patterns = line.replaceFirst("\\s\\|\\s.*", "").split("\\s");
		for (int i = 0; i < patterns.length; i++) {
			Set<Character> p = new HashSet<>();
			for (char c : patterns[i].toCharArray())
				p.add(c);
			int[] unions = {(int)p.stream().filter(set1::contains).count(),
				(int)p.stream().filter(set2::contains).count(),
				(int)p.stream().filter(set3::contains).count(),
				(int)p.stream().filter(set4::contains).count(),};
			setmap.put(p, getDigit(map, unions));
		}
	}

	private int getDigit(Map<int[], Integer> map, int[] unions) {
		for (var entry : map.entrySet()) {
			if (Arrays.equals(entry.getKey(), unions))
				return entry.getValue();
		}

		return -1;
	}

	private void fillSets(String line) {
		String[] patterns = line.replaceFirst("\\s\\|\\s.*", "").split("\\s");
		Arrays.sort(patterns, (p1, p2) -> Integer.compare(p1.length(), p2.length()));

		for (var p : patterns) {
			char[] chars = p.toCharArray();
			if (chars.length == 2) {
				for (char c : chars)
					set1.add(c);
			} else if (chars.length == 3) {
				for (char c : chars) {
					if (!set1.contains(c))
						set2.add(c);
				}
			} else if (chars.length == 4) {
				for (char c : chars) {
					if (!set1.contains(c))
						set3.add(c);
				}
			} else if (chars.length == 7) {
				for (char c : chars) {
					if (!set1.contains(c) && !set2.contains(c) && !set3.contains(c))
						set4.add(c);
				}
			}
		}
	}

	private void clear() {
		set1.clear();
		set2.clear();
		set3.clear();
		set4.clear();
		setmap.clear();
	}

}
