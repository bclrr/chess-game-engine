package game;

import pieces.movements.MovementType;

public class Move {

	private Position src;
	private Position dest;
	private MovementType type;
	
	public Move(Position src, Position dest, MovementType type) {
		this.src = src;
		this.dest = dest;
		this.type = type;
	}


	public Position src() {
		return src;
	}

	public Position dest() {
		return dest;
	}

	public MovementType getType() {
		return type;
	}
	
}
