package day4;

class PartOne {

	private final int[] sequence;
	private final int[][][] fields;
	private final Util utils;

	PartOne(int[] sequence, int[][][] fields) {
		this.sequence = sequence;
		this.fields = fields;
		this.utils = new Util(sequence, fields);
	}

	void run() {
		int endNum = 0;
		int[][] winner = null;

finish:
		for (var num : sequence) {
			for (var field : fields) {
				if (utils.markField(field, num)) {
					endNum = num;
					winner = field;
					break finish;
				}
			}
		}

		int sum = 0;
		for (var row : winner) {
			for (var num : row) {
				sum += (num == -1 ? 0 : num);
			}
		}

		System.out.println("left over sum: " + sum);
		System.out.println("final num: " + endNum);
		System.out.println("final score: " + sum * endNum);
	}

}
