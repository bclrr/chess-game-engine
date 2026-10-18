package game;

import pieces.Piece;

public abstract class BoardView {

	public abstract Piece getPiece(int x, int y);
	public abstract boolean isEmpty(int x, int y);
}
