package pieces.movements;

import game.BoardView;
import game.Position;

public interface Movement {
		
	public abstract MovementType isValidMove(Position src, Position dest, BoardView board);
	
}
