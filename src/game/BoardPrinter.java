package game;

public class BoardPrinter {

	public static void printMoves(Board board, int srcX, int srcY) {
		boolean[][] movements = board.getMoves(srcX, srcY);
		String betweenLine = "#";
		for(int i = 0; i < 8; i++) {
			betweenLine += "---#";
		}
		for(int i = 0; i < 8; i++) {
			String line = "|";
			for(int j = 0; j < 8; j++) {
				if(j == srcX && i == srcY)
					line += " X |";
				else
					line += movements[i][j] ? " o |" : "   |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);
	}
	
	public static void print(Board board) {
		String betweenLine = "#" + "----#".repeat(8);
		for(int i = 0; i < 8; i++) {
			String line = "|";
			for(int j = 0; j < 8; j++) {
				line += " " + board.get(j, i).toString() + " |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);
		
	}
}
