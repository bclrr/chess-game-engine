package game;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import pieces.Piece;
import pieces.PieceType;

public class Board implements BoardView {

	private Piece[][] pieces;
	private List<Move> moves;
	
	public Board(Piece[][] pieces) {
		this.moves = new LinkedList<Move>();
		this.pieces = pieces;
	}

	public void changePiece(int x, int y, Piece newPiece) {
		this.pieces[y][x] = newPiece;
	}
	
	@Override
	public Piece get(int x, int y) {
		return this.pieces[y][x];
	}

	@Override
	public boolean isEmpty(int x, int y) {
		return get(x, y).getPieceType() == PieceType.NONE;
	}

	@Override
	public Move getLastMovement() {
		try {
			return this.moves.getLast();
		} catch(NoSuchElementException e) {
			return null;
		}
	}

	public boolean[][] getMoves(int x, int y) {
		boolean[][] movements =  new boolean[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movements[i][j] = isValidMove(x, y, j, i);
			}
		}
		return movements;
	}

	private boolean isValidMove(int srcX, int srcY, int destX, int destY) {
		if(get(srcX, srcY).getPieceColor() == get(destX, destY).getPieceColor()) {
			return false;
		}
		return get(srcX, srcY).isValidMove(srcX, srcY, destX, destY, this);
	}
	
}
