package day11;

class PartTwo {

	private int flashes;

	void run(int[][] grid) {
		int i = 0;
		while (true) {
			this.flashes = 0;
			iterate(grid);
			Util.printGrid(grid, i + 1);
			if (this.flashes == grid.length * grid[0].length) {
				System.out.println("step: " + (i + 1));
				break;
			}
			i++;
		}

	}

	private void iterate(int[][] grid) {
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j) {
				dfs(grid, i, j);
			}
		}

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j) {
				grid[i][j] = grid[i][j] == -1 ? 0 : grid[i][j];
			}
		}
	}

	private void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == -1)
			return;
		if (++grid[i][j] <= 9)
			return;

		grid[i][j] = -1;
		this.flashes++;
		dfs(grid, i - 1, j - 1);
		dfs(grid, i - 1, j);
		dfs(grid, i - 1, j + 1);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
		dfs(grid, i + 1, j - 1);
		dfs(grid, i + 1, j);
		dfs(grid, i + 1, j + 1);
	}

}
