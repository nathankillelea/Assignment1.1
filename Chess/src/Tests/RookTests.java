package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class RookTests {
	
	@Test
	void moveDiagonallyWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Rook(0, 0, Color.WHITE));
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Move diagonally with no pieces blocking path", board);
		
		assertFalse(rook00.equals(squares[3][4].getPiece()));
		board.movePiece(rook00,3,4);
		assertFalse(rook00.equals(squares[3][4].getPiece()));
		
		printEnd("Move diagonally with no pieces blocking path", board);
	}
	
	@Test 
	void moveUpWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Rook(0, 0, Color.WHITE));
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Move up with no pieces blocking path", board);
		
		assertFalse(rook00.equals(squares[0][7].getPiece()));
		board.movePiece(rook00,0,7);
		assertTrue(rook00.equals(squares[0][7].getPiece()));
		
		printEnd("Move up with no pieces blocking path", board);
	}
	
	@Test 
	void moveRightWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Rook(0, 0, Color.WHITE));
		Piece rook00 = squares[0][0].getPiece();
		
		printStart("Move right with no pieces blocking path", board);
		
		assertFalse(rook00.equals(squares[7][0].getPiece()));
		board.movePiece(rook00,7,0);
		assertTrue(rook00.equals(squares[7][0].getPiece()));
		
		printEnd("Move right with no pieces blocking path", board);
	}
	
	@Test 
	void moveDownWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Rook(7, 7, Color.WHITE));
		Piece rook77 = squares[7][7].getPiece();
		
		printStart("Move down with no pieces blocking path", board);
		
		assertFalse(rook77.equals(squares[7][0].getPiece()));
		board.movePiece(rook77,7,0);
		assertTrue(rook77.equals(squares[7][0].getPiece()));
		
		printEnd("Move down with no pieces blocking path", board);
	}
	
	@Test 
	void moveLeftWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Rook(7, 7, Color.WHITE));
		Piece rook77 = squares[7][7].getPiece();
		
		printStart("Move left with no pieces blocking path", board);
		
		assertFalse(rook77.equals(squares[0][7].getPiece()));
		board.movePiece(rook77,0,7);
		assertTrue(rook77.equals(squares[0][7].getPiece()));
		
		printEnd("Move left with no pieces blocking path", board);
	}
	
	@Test
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Rook(7, 7, Color.WHITE));
		Piece rook77 = squares[7][7].getPiece();
		squares[0][7].setPiece(new Queen(0, 7, Color.BLACK));
		
		printStart("Capture piece", board);
		
		assertFalse(rook77.equals(squares[0][7].getPiece()));
		board.movePiece(rook77,0,7);
		assertTrue(rook77.equals(squares[0][7].getPiece()));
		
		printEnd("Capture piece", board);
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

}
