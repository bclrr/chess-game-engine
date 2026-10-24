package game;

public class BoardPrinter {

	public static void printMoves(Board board, Position src) {
		boolean[][] movements = board.getMoves(src);
		String betweenLine = "#";
		for(int i = 0; i < 8; i++) {
			betweenLine += "---#";
		}
		for(int i = 0; i < 8; i++) {
			String line = "|";
			for(int j = 0; j < 8; j++) {
				if(j == src.x() && i == src.y())
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
				line += " " + board.get(new Position(j, i)).toString() + " |";
			}
			System.out.println(betweenLine);
			System.out.println(line);
		}
		System.out.println(betweenLine);
		
	}
}
