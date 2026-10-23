package pieces.movements;

import game.BoardView;

public class KingMovement implements Movement {

	public KingMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		if(difX == 1 || difY == 1) {
			return MovementType.NORMAL;
		}
		if(difY != 0) {
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