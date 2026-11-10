package game;

import board.BoardView;
import board.Position;
import pieces.PieceColor;
import pieces.movements.MovementType;

public class RuleChecker {
	
	public boolean isSquareAttack(PieceColor colorSquare, Position square, BoardView board) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				Position src = new Position(x, y);
				if(isPieceAttackingSquare(src, colorSquare, square, board)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isPieceAttackingSquare(Position src, PieceColor colorSquare, Position square, BoardView board) {
		if(board.isEmpty(src)) {
			return false;
		}
		if(board.get(src).color() == colorSquare) {
			return false;
		}
		return board.get(src).isValidMove(src, square, board) != MovementType.INVALID;
	}
	
	public boolean isLegalMove(Position src, Position dest, MovementType type, BoardView board) {
		if(type == MovementType.INVALID) {
			return false;
		}
		if(type == MovementType.SHORT_CASTLING || type == MovementType.LONG_CASTLING) {
			PieceColor color = board.get(src).color();
			Position step = dest.minus(src).step();
			Position pos = src;
			
			while(pos.x() != dest.plus(step).x()) {
				if(isSquareAttack(color, pos, board)) {
					return false;
				}
				pos = pos.plus(step);
			}
			return false;
		}
		return false;
	}
	
}
