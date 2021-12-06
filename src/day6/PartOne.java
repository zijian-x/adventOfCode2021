package day6;

import java.util.Arrays;

class PartOne {

	private long[] groups = new long[9];
	private int iteration;

	PartOne(int[] fishes, int iteration) {
		this.iteration = iteration;
		for (int cycle : fishes)
			groups[cycle]++;
	}

	void run() {
		for (int i = 0; i < iteration; i++) {
			long newborns = groups[0];
			for (int j = 1; j < groups.length; ++j)
				groups[j - 1] = groups[j];
			groups[8] = newborns;
			groups[6] += newborns;

			long sum = Arrays.stream(groups).sum();
			System.out.println(sum);
		}
	}

}
