package pieces.movements;

import board.BoardView;
import board.Position;

public class KingMovement implements Movement {

	public KingMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		Position dif = dest.minus(src).abs();
		if(dif.x() == 1 || dif.y() == 1) {
			return MovementType.NORMAL;
		}
		
		if(dif.y() != 0 || dif.x() != 2) {
			return MovementType.INVALID;
		}
		
		dif = dest.minus(src);
		Position step = dif.step();
		Position pos = src.plus(step);
		
		while(pos.x() != dest.plus(step).x()) {
			if(!board.isEmpty(pos)) {
				return MovementType.INVALID;
			}
			pos = pos.plus(step);
		}

		if(dif.x() > 0 && board.canShortCastle(board.get(src).color())) {
			return MovementType.SHORT_CASTLING;
		}
		if(dif.x() < 0 && board.canLongCastle(board.get(src).color())) {
			return MovementType.LONG_CASTLING;
		}
		
		return MovementType.INVALID;
	}
	
}