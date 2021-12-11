package day11;

class Util {

	static void printGrid(int[][] grid, int iteration) {
		System.out.printf("After step %d: \n", iteration);
		for (int[] row : grid) {
			for (int i : row)
				System.out.print(i);
			System.out.println();
		}
	}

}
