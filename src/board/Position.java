package board;

public record Position(int x, int y) {

	
	public static Position of(int x, int y) {
		return new Position(x, y);
	}
	public Position minus(Position src) {
		return new Position(x - src.x(), y - src.y());
	}
	
	public Position abs() {
		return new Position(Math.abs(x), Math.abs(y));
	}
	
	public Position step() {
		return new Position(Integer.signum(x), Integer.signum(y));
	}

	public Position plus(Position other) {
		return new Position(x + other.x(), y + other.y());
	}
	
	public Position plus(int dx, int dy) {
		return new Position(x + dx, y + dy);
	}
	
	public static Position avg(Position a, Position b) {
		return new Position((a.x() + b.x()) / 2, (a.y() + b.y()) / 2);
	}
}
