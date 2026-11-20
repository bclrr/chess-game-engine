package game;

import board.BoardView;
import board.Position;
import pieces.PieceColor;
import pieces.movements.MovementType;

public class RuleChecker {
	
	private final BoardView board;
	
	public RuleChecker(BoardView board) {
		this.board = board;
	}
	
	private boolean isAttacking(Position piece, Position square, PieceColor color) {
		
		if(board.get(piece).color() == color) {
			return false;
		}
		
		return board.get(piece).isValidMove(piece, square, board) != MovementType.INVALID;
	}
		
	public boolean isAttacked(Position square, PieceColor color) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(isAttacking(Position.of(x, y), square, color)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isLegalMove(Position src, Position dest, MovementType type) {
		if(type == MovementType.INVALID || board.isEmpty(src)) {
			return false;
		}
		if(type == MovementType.SHORT_CASTLING || type == MovementType.LONG_CASTLING) {
			PieceColor color = board.get(src).color();
			Position step = dest.minus(src).step();
			Position pos = src;
			
			while(pos.x() != dest.plus(step).x()) {
				if(isAttacked(pos, color)) {
					return false;
				}
				pos = pos.plus(step);
			}
			return false;
		}
		return false;
	}
	
}
