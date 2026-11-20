package game;

import board.Position;
import pieces.Piece;
import pieces.movements.MovementType;

public record Move(
		Position src,
		Position dest,
		Position capturedAt,
		Piece captured,
		MovementType type,
		Position enPassant,
		int castlingRights) {

}
