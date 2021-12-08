package day7;

import java.util.Arrays;
import java.util.function.UnaryOperator;

class PartTwo {

	private final int[] pos;

	PartTwo(int[] pos) {
		this.pos = pos;
	}

	void run() {
		UnaryOperator<Integer> step = x -> ((int)Math.pow(x, 2) + x) / 2;
		int max = Arrays.stream(pos).max().getAsInt();
		long minCost = Integer.MAX_VALUE;
		for (int i = 0; i <= max; i++) {
			int fuels = 0;
			for (var p : pos) {
				fuels += step.apply(Math.abs(p - i));
			}
			minCost = Math.min(minCost, fuels);
		}

		System.out.println(minCost);

	}

}
