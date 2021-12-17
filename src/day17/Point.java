package day17;

class Point {

	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point(Point p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
	}

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

	void incX() {
		this.x++;
	}

	void incY() {
		this.y++;
	}

	void decX() {
		this.x--;
	}

	void decY() {
		this.y--;
	}

	@Override
	public String toString() {
		return "x: " + this.x + ", y: " + this.y;
	}

}
