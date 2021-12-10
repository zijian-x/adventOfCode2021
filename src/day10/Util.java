package day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Util {

	private static final Map<Character, Character> pairs = new HashMap<>();
	static {
		pairs.put(')', '(');
		pairs.put(']', '[');
		pairs.put('}', '{');
		pairs.put('>', '<');
	}
	private static final Map<Character, Integer> corruptScoreMap = new HashMap<>();
	static {
		corruptScoreMap.put(')', 3);
		corruptScoreMap.put(']', 57);
		corruptScoreMap.put('}', 1197);
		corruptScoreMap.put('>', 25137);
	}
	private static final Map<Character, Integer> completionScoreMap = new HashMap<>();
	static {
		completionScoreMap.put('(', 1);
		completionScoreMap.put('[', 2);
		completionScoreMap.put('{', 3);
		completionScoreMap.put('<', 4);
	}

	static int getCorruptScore(String line) {
		Stack<Character> stack = new Stack<>();
		for (char c : line.toCharArray()) {
			if (pairs.values().contains(c)) {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty() || stack.pop() != pairs.get(c))
				return corruptScoreMap.get(c);
		}

		return 0;
	}

	static long getCompletionScore(String line) {
		Stack<Character> stack = new Stack<>();
		long score = 0;
		for (char c : line.toCharArray()) {
			if (pairs.values().contains(c)) {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty() || stack.pop() != pairs.get(c))
				return 0;
		}

		while (!stack.isEmpty())
			score = score * 5 + completionScoreMap.get(stack.pop());

		return score;
	}

}

