package pieces.movements;

public enum MovementType {
	INVALID,
	NORMAL,
	SHORT_CASTLING,
	LONG_CASTLING,
	EN_PASSANT,
	DOUBLE_PUSH,
	PROMOTION;
	
	public static boolean isValide(MovementType type) {
		return type != null && type != INVALID;
	}
}
