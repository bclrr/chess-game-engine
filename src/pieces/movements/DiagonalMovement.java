package pieces.movements;

import game.BoardView;
import game.Position;

public class DiagonalMovement implements Movement {

	public DiagonalMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {

		Position dif = dest.minus(src);

		if(dif.x() != dif.y() && dif.x() * -1 != dif.y()) {
			return MovementType.INVALID;
		}
		
		Position step = dif.step();
		Position pos = src.plus(step);

		while(pos.x() != dest.x()) {
			if(!board.isEmpty(pos)) {
				return MovementType.INVALID;
			}
	
			pos = pos.plus(step);
		}

		return MovementType.NORMAL;
	}

}
