package day7;

import java.util.Arrays;

class PartOne {

	private final int[] pos;

	PartOne(int[] pos) {
		this.pos = pos;
	}

	void run() {
		int max = Arrays.stream(pos).max().getAsInt();
		long minCost = Integer.MAX_VALUE;
		for (int i = 0; i <= max; i++) {
			int fuels = 0;
			for (var p : pos) {
				fuels += Math.abs(p - i);
			}
			minCost = Math.min(minCost, fuels);
		}

		System.out.println(minCost);
	}

}
