package board;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;
import pieces.movements.MovementType;

public class Board implements BoardView {

	private final Piece[][] pieces;
	private Position enPassant;
	
	private int castlingRights;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
		this.enPassant = null;
		this.castlingRights = 0b1111;
	}

	@Override
	public boolean isEmpty(Position pos) {
		return get(pos).type() == PieceType.NONE;
	}

	@Override
	public Position getEnPassant() {
		return enPassant;
	}
	
	public void setEnPassant(Position enPassant) {
		this.enPassant = enPassant;
	}

	@Override
	public Piece get(Position pos) {
		return this.pieces[pos.y()][pos.x()];
	}
	
	public void set(Position pos, Piece newPiece) {
		this.pieces[pos.y()][pos.x()] = newPiece;
	}

	public void set(int x, int y, PieceType type, PieceColor color) {
		set(new Position(x, y), PieceFactory.create(type, color));
	}
	
	public boolean[][] getMoves(Position pos) {
		boolean[][] movements =  new boolean[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movements[i][j] = isValidMove(pos, new Position(j, i)) != MovementType.INVALID;
			}
		}
		return movements;
	}
	
	public boolean[][] getMoves(int x, int y) {
		return getMoves(new Position(x, y));
	}

	public MovementType isValidMove(Position src, Position dest) {
		if(get(src).color() == get(dest).color()) {
			return MovementType.INVALID;
		}
		return get(src).isValidMove(src, dest, this);
	}

	@Override
	public boolean canShortCastle(PieceColor color) {
		return canCastle(CastlingRight.shortOf(color));
	}

	@Override
	public boolean canLongCastle(PieceColor color) {
		return canCastle(CastlingRight.longOf(color));
	}
	
	public int getCastlingRights() {
		return this.castlingRights;
	}
	
	public void setCastlingRights(int rights) {
		this.castlingRights = rights;
	}
	
	private boolean canCastle(CastlingRight right) {
		return (castlingRights & right.getValue()) != 0;
	}
	
	public void removeRight(CastlingRight right) {
		this.castlingRights &= ~right.getValue();
	}
	
}
