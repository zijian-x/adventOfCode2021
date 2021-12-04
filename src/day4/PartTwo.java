package day4;

class PartTwo {

	private final int[] sequence;
	private final int[][][] fields;
	private final Util utils;

	PartTwo(int[] sequence, int[][][] fields) {
		this.sequence = sequence;
		this.fields = fields;
		this.utils = new Util(sequence, fields);
	}

	void run() {
		boolean[] flags = new boolean[fields.length];
		int[][] lastWinner = null;
		int endNum = 0;

finish:
		for (var num : sequence) {
			for (int i = 0; i < fields.length; i++) {
				if (!flags[i] && utils.markField(fields[i], num))
					flags[i] = true;
				if (utils.allFlagsTrue(flags)) {
					lastWinner = fields[i];
					endNum = num;
					break finish;
				}
			}
		}

		int sum = 0;
		for (var row : lastWinner) {
			for (var num : row)
				sum += num == -1 ? 0 : num;
		}

		utils.printAllFields();
		System.out.println("left over sum: " + sum);
		System.out.println("final num: " + endNum);
		System.out.println("final score: " + sum * endNum);
	}

}
