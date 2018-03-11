package Tests;
import Pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.*;

class BoardTests {
	
	@Test
	void moveOutOfBounds() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Rook(0, 0, Color.WHITE));
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Move out of bounds", board);
		
		assertFalse(rook00.isValidMove(squares,-1,0));
		board.movePiece(rook00,-1,0);
		assertFalse(rook00.isValidMove(squares,0,-1));
		board.movePiece(rook00,0,-1);
		assertFalse(rook00.isValidMove(squares,8,0));
		board.movePiece(rook00,8,0);
		assertFalse(rook00.isValidMove(squares,0,8));
		board.movePiece(rook00,0,8);

		printEnd("Move out of bounds", board);
	}
	
	@Test
	void stayInPlace() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Stay in place", board);
		
		assertFalse(rook00.isValidMove(squares,0,0));
		assertTrue(board.getCurrentPlayer() == Color.WHITE);
		board.movePiece(rook00,0,0);
		assertTrue(board.getCurrentPlayer() == Color.WHITE);
		
		printEnd("Stay in place", board);
	}
	
	@Test
	void properMoveTurnSwitching() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece pawn01 = squares[0][1].getPiece();		
		assertTrue(board.getCurrentPlayer() == Color.WHITE);
		board.movePiece(pawn01,0,3);
		assertTrue(board.getCurrentPlayer() == Color.BLACK);
	}
	
	@Test
	void moveOntoSameColorPiece() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Move onto same color piece", board);
		
		assertFalse(rook00.equals(squares[0][1].getPiece()));
		board.movePiece(rook00,0,1);
		assertFalse(rook00.equals(squares[0][1].getPiece()));
		
		printEnd("Move onto same color piece", board);
	}
	
	@Test
	void checkmate() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		
		printMessage("Move 0", board);
		
		Piece pawn51 = squares[5][1].getPiece();
		board.movePiece(pawn51,5,3);
		
		printMessage("Move 1", board);

		Piece pawn46 = squares[4][6].getPiece();
		board.movePiece(pawn46,4,4);
		
		printMessage("Move 2", board);

		Piece pawn61 = squares[6][1].getPiece();
		board.movePiece(pawn61,6,3);
		
		printMessage("Move 3", board);

		Piece queen37 = squares[3][7].getPiece();
		board.movePiece(queen37,7,3);
		
		printMessage("Move 4", board);

		Piece king40 = squares[4][0].getPiece();
		assertFalse(king40.equals(squares[5][1].getPiece()));
		board.movePiece(king40,5,1);
		assertFalse(king40.equals(squares[5][1].getPiece())); // can't move, is in check
		
		printMessage("Move 4/5", board);
		
		assertTrue(board.isCheckmate());
	}
	
	@Test
	void notCheckmate() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		assertFalse(board.isCheckmate());
		
		printMessage("Move 0", board);

		Piece pawn41 = squares[4][1].getPiece();
		board.movePiece(pawn41,4,3);
		
		printMessage("Move 1", board);
		assertFalse(board.isCheckmate());
	}
	
	@Test
	void stalemate() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		
		squares[0][7].setPiece(new King(0, 7, Color.WHITE));
		squares[1][5].setPiece(new King(1, 5, Color.BLACK));
		squares[3][6].setPiece(new Knight(3, 6, Color.BLACK));
		
		printMessage("Move 0", board);
		
		Piece king07 = squares[0][7].getPiece();
		assertFalse(king07.equals(squares[1][7].getPiece()));
		board.movePiece(king07,1,7);
		assertFalse(king07.equals(squares[1][7].getPiece()));
		
		printMessage("Move Attempt 1", board);

		assertFalse(king07.equals(squares[1][6].getPiece()));
		board.movePiece(king07,1,6);
		assertFalse(king07.equals(squares[1][6].getPiece()));
		
		printMessage("Move Attempt 2", board);
		
		assertFalse(king07.equals(squares[0][6].getPiece()));
		board.movePiece(king07,0,6);
		assertFalse(king07.equals(squares[0][6].getPiece()));
		
		printMessage("Move Attempt 3", board);
		
		assertTrue(board.isStalemate());
		assertFalse(board.isCheckmate());
	}
	
	@Test
	void notStalemate() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		assertFalse(board.isStalemate());
		
		printMessage("Move 0", board);

		Piece pawn41 = squares[4][1].getPiece();
		board.movePiece(pawn41,4,3);
		
		printMessage("Move 1", board);
		assertFalse(board.isStalemate());
	}
	
	public void printStart(String message, Board board) {
		System.out.print(message + " start:");
		board.printBoard();
		System.out.println();
	}
	
	public void printEnd(String message, Board board) {
		System.out.print(message + " end:");
		board.printBoard();
		System.out.println();
	}
	
	void printMessage(String message, Board board) {
		System.out.print(message);
		board.printBoard();
		System.out.println();
	}

}
