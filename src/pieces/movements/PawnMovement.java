package pieces.movements;

import game.BoardView;
import game.Move;
import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceType;

public class PawnMovement implements Movement {

	private int direction;
	
	public PawnMovement(int direction) {
		this.direction = direction;
	}
	
	@Override
	//TODO implement with GameState class
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		int difY = destY - srcY;
		int difX = Math.abs(destX - srcX);

		//check destination same direction than the color of the piece (white -1; black 1)
		if(difY * direction <= 0) {
			return MovementType.INVALID;
		}

		difY = Math.abs(difY);
		boolean destEmpty = board.isEmpty(destX, destY);

		//Two squares on the first turn
		if(difY == 2) {
			Piece myPiece = board.get(srcX, srcY);
			boolean isValid = (
					(myPiece.getColor() == PieceColor.BLACK && srcY == 1) ||
					(myPiece.getColor() == PieceColor.WHITE && srcY == 6)
				) && difX == 0 && destEmpty;
			return isValid ? MovementType.DOUBLE_PUSH : MovementType.INVALID;
		}

		//Advancing only one square for all subsequent moves
		if(difY != 1) {
			return MovementType.INVALID;
		}

		//Forward movement without blocked path
		if(difX == 0) {
			return destEmpty ? MovementType.NORMAL : MovementType.INVALID;
		}
		
		//Only taking moves remaining
		if(difX != 1) {
			return MovementType.INVALID;
		}
		
		//Taking move
		if(!destEmpty) {
			return MovementType.NORMAL;
		}

		//En passant
		Move move = board.getLastMovement();
		if(move == null) {
			return MovementType.INVALID;
		}
		
		if(move.getType() != MovementType.DOUBLE_PUSH) {
			return MovementType.INVALID;
		}
		
		return move.getDestY() == srcY && Math.abs(move.getDestX() - destX) == 0 ? MovementType.EN_PASSANT : MovementType.INVALID;
	}

}