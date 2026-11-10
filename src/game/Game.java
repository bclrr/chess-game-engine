package game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import board.Board;
import board.BoardView;
import board.Position;
import pieces.Piece;
import pieces.PieceFactory;
import pieces.movements.MovementType;

public class Game {

	private final Board board;
	private final RuleChecker rule;
	private final Deque<Move> moves;
	
	public Game(Board board, RuleChecker rule) {
		this.board = board;
		this.rule = rule;
		this.moves = new LinkedList<Move>();
	}
	
	public boolean move(Position src, Position dest) {
		MovementType moveType = board.isValidMove(src, dest);
		
		if(!rule.isLegalMove(src, dest, moveType, board)) {
			return false;
		}
		
		Position capturedAt = moveType == MovementType.EN_PASSANT
				? new Position(dest.x(), src.y())
				: dest;

		apply(new Move(src, dest, moveType, capturedAt, board.get(capturedAt)));
		return true;
	}
	
	public void apply(Move move) {
		if(move.type() == MovementType.INVALID) {
			return;
		}

		if(move.type() == MovementType.CASTLING) {
			//TODO
			return;
		}

		if(move.type() == MovementType.PROMOTION) {
			//TODO
			return;
		}

		Piece piece = board.get(move.src());
		board.set(move.src(), PieceFactory.empty());
		board.set(move.capturedAt(), PieceFactory.empty());
		board.set(move.dest(), piece);
		moves.add(move);
	}
	
	public void rollBack() {
		Move move = moves.peekLast();
		if(move == null) {
			return ;
		}
		
		board.set(move.src(), board.get(move.dest()));
		board.set(move.dest(), PieceFactory.empty());
		board.set(move.capturedAt(), move.captured());
	}
	
}
