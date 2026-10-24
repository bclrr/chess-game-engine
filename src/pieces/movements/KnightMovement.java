package pieces.movements;

import game.BoardView;
import game.Position;

public class KnightMovement implements Movement {

	public KnightMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		Position dif = dest.minus(src).abs();
		return (dif.x() == 2 && dif.y() == 1) || (dif.x() == 1 && dif.y() == 2) ? MovementType.NORMAL : MovementType.INVALID;
	}

}
