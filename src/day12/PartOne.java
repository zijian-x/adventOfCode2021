package day12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PartOne {

	private static final String START = "start";
	private static final String END = "end";

	private final Map<String, Set<String>> map;
	private final List<List<String>> paths;

	PartOne(List<String> lines) {
		this.map = initMap(lines);
		this.paths = new LinkedList<>();
	}

	void run() {
		Set<String> visited = new HashSet<>();
		visited.add(START);
		findPaths(new LinkedList<>(), START, visited, null);
		System.out.println(paths.size());
	}

	private void findPaths(List<String> prev, String current, Set<String> visited, String single) {
		prev.add(current);
		if (END.equals(current)) {
			paths.add(prev);
			return;
		}

		for (var reachable : map.get(current)) {
			if (!visited.contains(reachable)) {
				if (isSmallCave(current)) {
					if (single == null)
						single = current;
					else
						visited.add(current);
				}
				findPaths(new LinkedList<>(prev), reachable, new HashSet<>(visited), single);
			}
		}
	}

	private boolean isSmallCave(String cave) {
		return cave.chars().allMatch(Character::isLowerCase);
	}

	static Map<String, Set<String>> initMap(List<String> lines) {
		Map<String, Set<String>> map = new HashMap<>();
		for (var line : lines) {
			var nodes = line.split("-");
			var reachables1 = map.getOrDefault(nodes[0], new HashSet<>());
			var reachables2 = map.getOrDefault(nodes[1], new HashSet<>());
			reachables1.add(nodes[1]);
			reachables2.add(nodes[0]);
			map.put(nodes[0], reachables1);
			map.put(nodes[1], reachables2);
		}

		return map;
	}

}
