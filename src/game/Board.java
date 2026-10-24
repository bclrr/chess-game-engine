package game;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;
import pieces.movements.MovementType;

public class Board implements BoardView {

	private Piece[][] pieces;
	private List<Move> moves;
	
	public Board(Piece[][] pieces) {
		this.moves = new LinkedList<Move>();
		this.pieces = pieces;
	}

	public void changePiece(Position pos, Piece newPiece) {
		this.pieces[pos.y()][pos.x()] = newPiece;
	}
	
	public void changePiece(int x, int y, PieceType type, PieceColor color) {
		changePiece(new Position(x, y), PieceFactory.create(type, color));
	}
	
	@Override
	public Piece get(Position pos) {
		return this.pieces[pos.y()][pos.x()];
	}

	@Override
	public boolean isEmpty(Position pos) {
		return get(pos).type() == PieceType.NONE;
	}

	@Override
	public Move getLastMovement() {
		try {
			return this.moves.getLast();
		} catch(NoSuchElementException e) {
			return null;
		}
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
	
	public boolean move(Position src, Position dest) {
		MovementType moveType = isValidMove(src, dest);
		if(moveType == MovementType.INVALID) {
			return false;
		}
		
		if(!isLegalMove(src, dest)) {
			return false;
		}
		
		return apply(new Move(src, dest, moveType));
	}
	
	private boolean apply(Move move) {
		changePiece(move.dest(), this.get(move.src()));
		changePiece(move.src(), PieceFactory.empty());
		return moves.add(move);
	}
	
	private boolean rollBack() {
		Move lastMove = this.getLastMovement();
		if(lastMove == null) {
			return true;
		}

		return false;
	}
	
	
}
