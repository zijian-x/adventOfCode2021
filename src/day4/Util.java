package day4;

class Util {

	private final int[] sequence;
	private final int[][][] fields;

	Util(int[] sequence, int[][][] fields) {
		this.sequence = sequence;
		this.fields = fields;
	}

	boolean markField(int[][] field, int num) {
		boolean bingo = false;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == num) {
					field[i][j] = -1;
					bingo = bingo || checkBingo(field, i, j);
				}
			}
		}

		return bingo;
	}

	static boolean checkBingo(int[][] field, int row, int col) {
		return checkHorizontal(field, row, 0) || checkVertical(field, 0, col);
	}

	static boolean checkHorizontal(int[][] field, int row, int col) {
		if (col == field[row].length)
			return true;
		return field[row][col] == -1 && checkHorizontal(field, row, col + 1);
	}

	static boolean checkVertical(int[][] field, int row, int col) {
		if (row == field.length)
			return true;
		return field[row][col] == -1 && checkVertical(field, row + 1, col);
	}

	void printAllFields() {
		for (var field : fields) {
			printField(field);
			System.out.println("=====");
		}
	}

	void printField(int[][] field) {
		for (var row : field) {
			for (var num : row)
				System.out.print(num + " ");
			System.out.println();
		}
	}

	boolean allFlagsTrue(boolean[] flags) {
		for (var flag : flags)
			if (!flag)
				return false;
		return true;
	}

}
