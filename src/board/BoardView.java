package board;

import pieces.Piece;
import pieces.PieceColor;

public interface BoardView {

	public abstract Piece get(Position pos);
	public abstract boolean isEmpty(Position pos);
	public abstract Position getEnPassant();
	public abstract boolean canShortCastle(PieceColor color);
	public abstract boolean canLongCastle(PieceColor color);
}
