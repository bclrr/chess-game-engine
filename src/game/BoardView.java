package game;

import pieces.Piece;

public interface BoardView {

	public abstract Piece get(int x, int y);
	public abstract boolean isEmpty(int x, int y);
	public abstract Move getLastMovement();
}
