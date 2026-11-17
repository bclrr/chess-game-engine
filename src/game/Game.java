package game;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
	
	public List<Move> legalMoves(Position src) {
		List<Move> moves = new ArrayList<Move>();
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				Position dest = new Position(x, y);
				MovementType type = isValidMove(src, dest);
				if(MovementType.isValide(type)) {
					moves.add(createMove(src, dest, type));
				}
			}
		}
		return moves;
	}
	
	public boolean move(Position src, Position dest) {
		MovementType type = isValidMove(src, dest);
		if(MovementType.isValide(type)) {
			return apply(createMove(src, dest, type));
		}
		return false;
	}
	
	private Move createMove(Position src, Position dest, MovementType moveType) {
		Position capturedAt = dest;
		if(moveType == MovementType.EN_PASSANT) {
			capturedAt = new Position(dest.x(), src.y());
		}

		return new Move(src, dest, moveType, capturedAt, board.get(capturedAt));
	}
	
	private MovementType isValidMove(Position src, Position dest) {
		MovementType moveType = board.isValidMove(src, dest);
		if(!rule.isLegalMove(src, dest, moveType, board)) {
			return MovementType.INVALID;
		}
		return moveType;
	}
	
	public boolean apply(Move move) {
		if(!MovementType.isValide(move.type())) {
			return false;
		}

		if(move.type() == MovementType.SHORT_CASTLING) {
			//TODO
			return false;
		}
		
		if(move.type() == MovementType.LONG_CASTLING) {
			//TODO
			return false;
		}

		if(move.type() == MovementType.PROMOTION) {
			//TODO
			return false;
		}

		Piece piece = board.get(move.src());
		board.set(move.src(), PieceFactory.empty());
		board.set(move.capturedAt(), PieceFactory.empty());
		board.set(move.dest(), piece);
		return moves.add(move);
	}
	
	public void rollBack() {
		Move move = moves.pollLast();
		if(move == null) {
			return;
		}
		
		board.set(move.src(), board.get(move.dest()));
		board.set(move.dest(), PieceFactory.empty());
		board.set(move.capturedAt(), move.captured());
	}
	
}
