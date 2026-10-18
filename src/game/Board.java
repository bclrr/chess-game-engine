package game;

import java.util.LinkedList;

import pieces.Piece;
import pieces.Tile;

public class Board {

	private Tile[][] chessBoard;
	private LinkedList<GameState> gameStates;
	
	public Board() {
		gameStates = new LinkedList<GameState>();
		chessBoard = new Tile[8][8];
		for(int i = 0; i < 8; i++) {
			chessBoard[i] = new Tile[8];
			for(int j = 0; j < 8; j++) {
				chessBoard[i][j] = new Tile();
			}
		}
	}
	
	public static Board getTestBoard() {
		return new Board();
	}
	
	public void addPiece(int x, int y, Piece newPiece) {
		chessBoard[x][y].changePiece(newPiece);
	}

	//TODO add gamestate for mooves like en passant
	private boolean canMove(int srcX, int srcY, int destX, int destY) {
		return chessBoard[srcX][srcY].canMove(srcX, srcY, destX, destY, chessBoard);
	}
	
	public boolean[][] getMovements(int srcX, int srcY) {
		boolean[][] movements =  new boolean[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				movements[i][j] = canMove(srcX, srcY, i, j);
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
				if(i == srcX && j == srcY)
					line += " X |";
				else
					line += movements[i][j] ? " o |" : "   |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);	
	}
	
}
