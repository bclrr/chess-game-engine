package game;

import pieces.PieceColor;
import pieces.PieceType;

public class GameState {

	private int sourceX;
	private int sourceY;
	private int destinationX;
	private int destinationY;
	private PieceColor color;
	private PieceType piece;
	
	
	public GameState(int _sourceX, int _sourceY, int _destinationX, int _destinationY, PieceColor _color, PieceType _piece) {
		sourceX = _sourceX;
		sourceY = _sourceY;
		destinationX = _destinationX;
		destinationY = _destinationY;
		color = _color;
		piece = _piece;
	}
	
}
