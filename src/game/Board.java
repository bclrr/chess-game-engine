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

	private boolean canMove(int srcX, int srcY, int destX, int destY) {
		if(get(srcX, srcY).getPieceColor() == get(destX, destY).getPieceColor()) {
			return false;
		}
		return get(srcX, srcY).canMove(srcX, srcY, destX, destY, this);
	}
	
	public boolean[][] getMovements(int srcX, int srcY) {
		boolean[][] movements =  new boolean[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movements[i][j] = canMove(srcX, srcY, j, i);
			}
		}
		return movements;
	}
	
	public void displayMovements(int srcX, int srcY) {
		boolean[][] movements = getMovements(srcX, srcY);
		String betweenLine = "#";
		for(int i = 0; i < 8; i++) {
			betweenLine += "---#";
		}
		for(int i = 0; i < 8; i++) {
			String line = "|";
			for(int j = 0; j < 8; j++) {
				if(j == srcX && i == srcY)
					line += " X |";
				else
					line += movements[i][j] ? " o |" : "   |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);	
	}
	
	public void display() {
		String betweenLine = "#" + "----#".repeat(8);
		for(int i = 0; i < 8; i++) {
			String line = "|";
			for(int j = 0; j < 8; j++) {
				line += " " + get(j, i).toString() + " |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);
		
	}
	
}
