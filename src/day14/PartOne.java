package day14;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class PartOne {

	private LinkedList<Character> sequence;
	private Map<String, Character> map;

	PartOne(List<String> lines) {
		sequence = new LinkedList<>();
		map = new HashMap<>();
		for (char c : lines.get(0).toCharArray())
			sequence.add(c);


		for (int i = 2; i < lines.size(); ++i) {
			var split = lines.get(i).split(" -> ");
			map.put(split[0], split[1].charAt(0));
		}
	}

	void run() {
		for (int i = 0; i < 10; ++i) {
			var iterator = sequence.listIterator();
			while (iterator.hasNext()) {
				var first = iterator.next();
				if (!iterator.hasNext())
					break;
				var second = iterator.next();
				iterator.previous();
				var elem = map.get("" + first + second);
				iterator.add(elem);
			}
		}
		Map<Character, Integer> quantities = new HashMap<>();
		for (Character c : sequence)
			quantities.put(c, quantities.getOrDefault(c, 0) + 1);
		int max = Collections.max(quantities.values());
		int min = Collections.min(quantities.values());
		System.out.printf("max: %d\tmin: %d\tdiff: %d\n", max, min, max - min);
	}

}
