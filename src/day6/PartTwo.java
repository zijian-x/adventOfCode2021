package day6;

import java.util.Arrays;

class PartTwo {

	private int[] groups = new int[9];
	private int iteration;

	PartTwo(int[] fishes, int iteration) {
		this.iteration = iteration;
		for (int cycle : fishes)
			groups[cycle]++;
	}

	void run() {
		for (int i = 0; i < iteration; i++) {
			int tmp = groups[0];
			for (int j = 1; j < groups.length; ++j) {
				groups[j - 1] = groups[j];
			}
			groups[groups.length - 1] += tmp;
		}

		int sum = Arrays.stream(groups).sum();
		System.out.println(sum);
	}

}
