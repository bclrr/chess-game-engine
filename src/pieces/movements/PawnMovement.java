package pieces.movements;

import game.BoardView;
import game.Move;
import game.Position;
import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceType;

public class PawnMovement implements Movement {

	private int direction;
	
	public PawnMovement(int direction) {
		this.direction = direction;
	}
	
	@Override
	//TODO PROMOTION type to add
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		Position dif = dest.minus(src);

		//check destination same direction than the color of the piece (white -1; black 1)
		if(dif.y() * direction <= 0) {
			return MovementType.INVALID;
		}

		dif = dif.abs();
		boolean destEmpty = board.isEmpty(dest);

		//Two squares on the first turn
		if(dif.y() == 2) {
			Piece myPiece = board.get(src);
			boolean pathClear = board.isEmpty(src.plus(0, direction));
			boolean isValid = (
					(myPiece.color() == PieceColor.BLACK && src.y() == 1) ||
					(myPiece.color() == PieceColor.WHITE && src.y() == 6)
				) && dif.x() == 0 && destEmpty && pathClear;
			return isValid ? MovementType.DOUBLE_PUSH : MovementType.INVALID;
		}

		//Advancing only one square for all subsequent moves
		if(dif.y() != 1) {
			return MovementType.INVALID;
		}

		//Forward movement without blocked path
		if(dif.x() == 0) {
			return destEmpty ? MovementType.NORMAL : MovementType.INVALID;
		}
		
		//Only taking moves remaining
		if(dif.x() != 1) {
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
		
		if(move.type() != MovementType.DOUBLE_PUSH) {
			return MovementType.INVALID;
		}
		
		if(move.dest().y() == src.y() && move.dest().x() == dest.x()) {
			return MovementType.EN_PASSANT;
		}

		return MovementType.INVALID;
	}

}