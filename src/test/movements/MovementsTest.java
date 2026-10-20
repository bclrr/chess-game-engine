package test.movements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Board;
import game.BoardFactory;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class MovementsTest {

/**

"........",
"........",
"........",
"........",
"........",
"........",
"........",
"........");
 */

	protected Board board;

    @BeforeEach
    void initTestMovements() {
        board = BoardFactory.createEmpty();
    }

    protected static boolean[][] grid(String... rows) {
    	boolean[][] g = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g[j][i] = rows[j].charAt(i) == 'o';
            }
        }
        return g;
    }
}
