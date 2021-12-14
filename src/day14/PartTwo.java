package day14;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartTwo {

	Map<String, Long> pairmap = new HashMap<>();
	Map<String, Character> rulemap = new HashMap<>();

	PartTwo(List<String> lines) {
		var init = lines.get(0);
		for (int i = 0; i < init.length() - 1; ++i) {
			char a = init.charAt(i);
			char b = init.charAt(i + 1);
			String pair = "" + a + b;
			pairmap.put(pair, pairmap.getOrDefault(pair, 0L) + 1);
		}

		for (int i = 2; i < lines.size(); ++i) {
			var split = lines.get(i).split(" -> ");
			rulemap.put(split[0], split[1].charAt(0));
		}
	}

	void run() {
		for (int i = 0; i < 39; ++i) {
			pairmap = iterate(pairmap);
		}

		Map<Character, Long> countmap = new HashMap<>();
		for (var pair : pairmap.keySet()) {
			String newpair = "" + pair.charAt(0) + rulemap.get(pair);
			for (char c : newpair.toCharArray()) {
				countmap.put(c, countmap.getOrDefault(c, 0L) + pairmap.get(pair));
			}
		}
		countmap.put('B', countmap.get('B') + 1);
		long max = Collections.max(countmap.values());
		long min = Collections.min(countmap.values());
		System.out.println(max - min);
	}

	private Map<String, Long> iterate(Map<String, Long> pairmap) {
		Map<String, Long> next = new HashMap<>();
		for (var cur : pairmap.keySet()) {
			char elem = rulemap.get(cur);
			long occurences = pairmap.get(cur);
			var pair1 = "" + cur.charAt(0) + elem;
			var pair2 = "" + elem + cur.charAt(1);
			next.put(pair1, occurences + next.getOrDefault(pair1, 0L));
			next.put(pair2, occurences + next.getOrDefault(pair2, 0L));

		}

		return next;
	}

}
