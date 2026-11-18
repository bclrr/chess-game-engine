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
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;
import pieces.movements.MovementType;

public class Game {

	private final Board board;
	private final RuleChecker rule;
	private final Deque<Move> moves;
	
	private PieceType promotionWhite;
	private PieceType promotionBlack;
	
	private PieceColor turn;
	
	public Game(Board board, RuleChecker rule) {
		this.board = board;
		this.rule = rule;
		this.moves = new LinkedList<Move>();
		setPromotion(PieceType.QUEEN, PieceColor.WHITE);
		setPromotion(PieceType.QUEEN, PieceColor.BLACK);
		updateTurn();
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

		if(board.get(move.src()).color() != turn) {
			return false;
		}
		
		if(move.type() == MovementType.SHORT_CASTLING) {

			Position posRookSrc = Position.of(move.src().x(), 0);
			Piece rook = board.get(posRookSrc);
			board.set(Position.of(move.src().x(), move.dest().y() + 1), rook);
			board.set(posRookSrc, PieceFactory.empty());
			board.setShortCastle(turn, false);
		}
		
		if(move.type() == MovementType.LONG_CASTLING) {
			
			Position posRookSrc = Position.of(move.src().x(), 7);
			Piece rook = board.get(posRookSrc);
			board.set(Position.of(move.src().x(), move.dest().y() - 1), rook);
			board.set(posRookSrc, PieceFactory.empty());
			board.setLongCastle(turn, false);
		}

		Piece piece = board.get(move.src());
		board.set(move.src(), PieceFactory.empty());
		board.set(move.capturedAt(), PieceFactory.empty());
		board.set(move.dest(), piece);
		
		if(move.type() == MovementType.PROMOTION) {
			board.set(move.dest(), PieceFactory.create(getPromotion(turn), turn));
		}
		
		updateEnPassant(move.type(), move.src(), move.dest());
		updateTurn();
	
		moves.add(move);
		return true;
	}
	
	public void rollBack() {
		Move move = moves.pollLast();
		if(move == null) {
			return;
		}
		
		if(board.get(move.dest()).color() == turn) {
			return;
		}
		
		updateTurn();
		updateEnPassant(move.type(), move.src(), move.dest());
		
		if(move.type() == MovementType.PROMOTION) {
			board.set(move.dest(), PieceFactory.create(PieceType.PAWN, turn));
		}
		
		if(move.type() == MovementType.SHORT_CASTLING) {
			
			Position posRookSrc = Position.of(move.src().x(), move.dest().y() + 1);
			Piece rook = board.get(posRookSrc);
			board.set(posRookSrc, PieceFactory.empty());
			board.set(Position.of(move.src().x(), 0), rook);
			board.setShortCastle(turn, false);
		}
		
		if(move.type() == MovementType.LONG_CASTLING) {
			
			Position posRookSrc = Position.of(move.src().x(), move.dest().y() - 1);
			Piece rook = board.get(posRookSrc);
			board.set(posRookSrc, PieceFactory.empty());
			board.set(Position.of(move.src().x(), 7), rook);
			board.setLongCastle(turn, false);
		}
		
		board.set(move.src(), board.get(move.dest()));
		board.set(move.dest(), PieceFactory.empty());
		board.set(move.capturedAt(), move.captured());
	}

	public PieceType getPromotion(PieceColor color) {
		if(color == PieceColor.WHITE) {
			return promotionWhite;
		}
		if(color == PieceColor.BLACK) {
			return promotionBlack;
		}
		return null;
	}

	public void setPromotion(PieceType type, PieceColor color) {
		if(type == PieceType.KING || type == PieceType.PAWN || type == PieceType.NONE || type == null) {
			return;
		}
		if(color == PieceColor.WHITE) {
			promotionWhite = type;
		}
		if(color == PieceColor.BLACK) {
			promotionBlack = type;
		}
	}
	
	private void updateTurn() {
		
		if(turn == null || turn == PieceColor.NONE) {
			turn = PieceColor.WHITE;
		}
		
		if(turn == PieceColor.BLACK) {
			turn = PieceColor.WHITE;
		}
		
		if(turn == PieceColor.WHITE) {
			turn = PieceColor.BLACK;
		}
	}
	
	private void updateEnPassant(MovementType type, Position src, Position dest) {
		if(type != MovementType.DOUBLE_PUSH) {
			board.setEnPassant(null);
			return;
		}
		board.setEnPassant(Position.avg(src, dest));
	}
	
}
