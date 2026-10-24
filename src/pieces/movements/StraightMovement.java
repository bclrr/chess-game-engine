package pieces.movements;

import game.BoardView;
import game.Position;

public class StraightMovement implements Movement {

	public StraightMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		
		Position dif = dest.minus(src);

		if((dif.x() != 0) == (dif.y() != 0)) {
			return MovementType.INVALID;
		}

		Position step = dif.step();
		Position pos = src.plus(step);

		while(pos.x() != dest.x() || pos.y() != dest.y()) {
			if(!board.isEmpty(pos)) {
				return MovementType.INVALID;
			}
			
			pos = pos.plus(step);
		}

		return MovementType.NORMAL;
	}

}
