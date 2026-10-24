package game;

import pieces.Piece;

public interface BoardView {

	public abstract Piece get(Position pos);
	public abstract boolean isEmpty(Position pos);
	public abstract Move getLastMovement();
}
