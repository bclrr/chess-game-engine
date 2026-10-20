package game;

public class Move {

	private int srcX;
	private int srcY;
	private int destX;
	private int destY;
	
	
	public Move(int srcX, int srcY, int destX, int destY) {
		this.srcX = srcX;
		this.srcY = srcY;
		this.destX = destX;
		this.destY = destY;
	}


	public int getSrcX() {
		return srcX;
	}

	public int getSrcY() {
		return srcY;
	}

	public int getDestX() {
		return destX;
	}

	public int getDestY() {
		return destY;
	}
	
}
