package board;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import game.Move;
import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;
import pieces.movements.MovementType;

public class Board {

	private final Piece[][] pieces;
	
	public Board(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public void set(Position pos, Piece newPiece) {
		this.pieces[pos.y()][pos.x()] = newPiece;
	}
	
	public void set(int x, int y, PieceType type, PieceColor color) {
		set(new Position(x, y), PieceFactory.create(type, color));
	}
	
	public Piece get(Position pos) {
		return this.pieces[pos.y()][pos.x()];
	}

	public boolean isEmpty(Position pos) {
		return get(pos).type() == PieceType.NONE;
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

	private MovementType isValidMove(Position src, Position dest) {
		if(get(src).color() == get(dest).color()) {
			return MovementType.INVALID;
		}
		return get(src).isValidMove(src, dest, this);
	}
	
	private boolean isLegalMove(Position src, Position dest) {
		//TODO
		return false;
	}
	
	
}
