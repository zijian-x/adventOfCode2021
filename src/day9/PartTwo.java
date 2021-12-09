package day9;

import java.util.List;
import java.util.PriorityQueue;

class PartTwo {

	private final List<String> lines;

	PartTwo(List<String> lines) {
		this.lines = lines;
	}

	void run() {
		int[][] field = Util.getField(lines);
		List<int[]> dentIndices = Util.getDentIndices(field);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (var indices : dentIndices) {
			int i = indices[0];
			int j = indices[1];
			int size = Util.dfs(field, i, j);

			if (pq.size() < 3) {
				pq.offer(size);
			} else if (pq.peek() < size) {
				pq.poll();
				pq.offer(size);
			}
		}

		System.out.println(pq.toString());
		System.out.println(pq.stream().reduce(1, (x, y) -> (x * y)));
	}

}
