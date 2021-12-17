package day17;

class PartOne {

	private final Point[] boundaries;

	PartOne(Point[] boundaries) {
		this.boundaries = boundaries;
	}

	void run() {
		var start = new Point(1, 1);
		for (int i = 0; i < boundaries.length; ++i)
			System.out.printf("b%d: [%s]\n", i + 1, boundaries[i]);

		// int highestY = 0;
		for (int i = start.getX(); i < boundaries[0].getX(); ++i) {
			for (int j = start.getY(); j < 20; ++j) {
				var curvePoints = Util.simulateEndPoint(start, boundaries);
				System.out.println("start: " + start);
				for (var p : curvePoints)
					System.out.println(p);
				start.setX(i);
				start.setY(j);
			}
		}
	}

}
