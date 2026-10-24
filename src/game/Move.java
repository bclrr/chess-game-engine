package game;

import pieces.Piece;
import pieces.movements.MovementType;

public record Move(Position src, Position dest, MovementType type, Position capturedAt, Piece captured) {

}
