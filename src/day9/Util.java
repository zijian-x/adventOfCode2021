package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Util {

	static int[][] getField(List<String> lines) {
		int[][] field = new int[lines.size()][lines.get(0).length()];
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < lines.get(i).length(); ++j) {
				field[i][j] = lines.get(i).charAt(j) - '0';
			}
		}

		return field;
	}

	static boolean isDent(int[][] field, int i, int j) {
		int cur = field[i][j];
		int dtop = field[i == 0 ? i : i - 1][j] - cur;
		int dbottom = field[i == field.length - 1 ? i : i + 1][j] - cur;
		int dleft = field[i][j == 0 ? j : j - 1] - cur;
		int dright = field[i][j == field[i].length - 1 ? j : j + 1] - cur;

		if (dtop == 0 && dbottom == 0 && dleft == 0 && dright == 0)
			return false;
		return dtop >= 0 && dbottom >= 0 && dleft >= 0 && dright >= 0;
	}

	static List<int[]> getDentIndices(int[][] field) {
		List<int[]> indices = new ArrayList<>();
		for (int i = 0; i < field.length; ++i) {
			for (int j = 0; j < field[i].length; ++j) {
				if (Util.isDent(field, i, j))
					indices.add(new int[]{i, j});
			}
		}

		return indices;
	}

	// FIXME weird bug which i cannot find
	static int dfs(int[][] field, int i, int j, int prev, Set<int[]> set) {
		if (i < 0 || i == field.length
				|| j < 0 || j == field[i].length
				|| field[i][j] == 9
				|| field[i][j] - prev != 1
				|| set.stream().anyMatch(arr -> Arrays.equals(arr, new int[]{i, j})))
			return 0;

		set.add(new int[]{i, j});

		return 1 + dfs(field, i + 1, j, field[i][j], set) + dfs(field, i - 1, j, field[i][j], set)
			+ dfs(field, i, j + 1, field[i][j], set) + dfs(field, i, j - 1, field[i][j], set);
	}

	static int dfs(int[][] field, int i, int j) {
		if (i < 0 || i == field.length || j < 0 || j == field[i].length
				|| field[i][j] == 9)
			return 0;
		field[i][j] = 9;
		return 1 + dfs(field, i + 1, j) + dfs(field, i - 1, j)
			+ dfs(field, i, j + 1) + dfs(field, i, j - 1);
	}


}
