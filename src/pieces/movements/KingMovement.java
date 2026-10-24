package pieces.movements;

import game.BoardView;
import game.Position;

public class KingMovement implements Movement {

	public KingMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		Position dif = dest.minus(src).abs();
		if(dif.x() == 1 || dif.y() == 1) {
			return MovementType.NORMAL;
		}
		if(dif.y() != 0) {
			return MovementType.INVALID;
		}
		
		return MovementType.INVALID;
	}
	
	private boolean canShortCastle() {
		//TODO
		return false;
	}

	private boolean canLongCastle() {
		//TODO
		return false;
	}
	
}