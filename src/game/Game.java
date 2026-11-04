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

public class Game implements BoardView {

	private final Board board;
	private final Deque<Move> moves;
	
	public Game(Board board) {
		this.board = board;
		this.moves = new LinkedList<Move>();
	}

	@Override
	public Piece get(Position pos) {
		return board.get(pos);
	}

	@Override
	public boolean isEmpty(Position pos) {
		return board.isEmpty(pos);
	}

	@Override
	public Move getLastMovement() {
		return this.moves.peekLast();
	}
	
	public boolean move(Position src, Position dest) {
		MovementType moveType = isValidMove(src, dest);
		if(moveType == MovementType.INVALID) {
			return false;
		}
		
		if(!isLegalMove(src, dest)) {
			return false;
		}
		
		Position capturedAt = moveType == MovementType.EN_PASSANT
				? new Position(dest.x(), src.y())
				: dest;

		apply(new Move(src, dest, moveType, capturedAt, get(capturedAt)));
		return true;
	}
	
	private void apply(Move move) {
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

		Piece piece = get(move.src());
		board.set(move.src(), PieceFactory.empty());
		board.set(move.capturedAt(), PieceFactory.empty());
		board.set(move.dest(), piece);
		moves.add(move);
	}
	
	private void rollBack() {
		Move move = this.getLastMovement();
		if(move == null) {
			return ;
		}
		
		board.set(move.src(), get(move.dest()));
		board.set(move.dest(), PieceFactory.empty());
		board.set(move.capturedAt(), move.captured());
	}
	
}
