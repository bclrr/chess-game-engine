package pieces.movements;

import game.BoardView;

public interface Movement {
		
	public abstract boolean isValidMove(int srcX, int srcY, int destX, int destY, BoardView board);
	
}
