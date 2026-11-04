package pieces.movements;

import board.BoardView;
import board.Position;

public interface Movement {
		
	public abstract MovementType isValidMove(Position src, Position dest, BoardView board);
	
}
