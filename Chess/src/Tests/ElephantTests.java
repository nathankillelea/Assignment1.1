package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class ElephantTests {

	@Test
	void moveDiagonallyWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Elephant(0, 0, Color.WHITE));
		Piece elephant00 = squares[0][0].getPiece();
		
		printStart("Move diagonally with no pieces blocking path", board);
		
		assertFalse(elephant00.equals(squares[3][4].getPiece()));
		board.movePiece(elephant00,3,4);
		assertFalse(elephant00.equals(squares[3][4].getPiece()));
		
		printEnd("Move diagonally with no pieces blocking path", board);
	}
	
	@Test 
	void moveMoreThanTwoSpacesWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Elephant(0, 0, Color.WHITE));
		Piece elephant00 = squares[0][0].getPiece();
		
		printStart("Move more than two spaces with no pieces blocking path", board);
		
		assertFalse(elephant00.equals(squares[0][3].getPiece()));
		board.movePiece(elephant00,0,3);
		assertFalse(elephant00.equals(squares[0][3].getPiece()));
		
		printEnd("Move more than two spaces with no pieces blocking path", board);
	}
	
	@Test 
	void moveUpTwoSpacesWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Elephant(0, 0, Color.WHITE));
		Piece elephant00 = squares[0][0].getPiece();
		
		printStart("Move up two spaces with no pieces blocking path", board);
		
		assertFalse(elephant00.equals(squares[0][2].getPiece()));
		board.movePiece(elephant00,0,2);
		assertTrue(elephant00.equals(squares[0][2].getPiece()));
		
		printEnd("Move up two spaces with no pieces blocking path", board);
	}
	
	@Test 
	void moveRightTwoSpacesWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][0].setPiece(new Elephant(0, 0, Color.WHITE));
		Piece elephant00 = squares[0][0].getPiece();
		
		printStart("Move right two spaces with no pieces blocking path", board);
		
		assertFalse(elephant00.equals(squares[2][0].getPiece()));
		board.movePiece(elephant00,2,0);
		assertTrue(elephant00.equals(squares[2][0].getPiece()));
		
		printEnd("Move right two spaces with no pieces blocking path", board);
	}
	
	@Test 
	void moveDownTwoSpacesWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Elephant(7, 7, Color.WHITE));
		Piece elephant77 = squares[7][7].getPiece();
		
		printStart("Move down two spaces with no pieces blocking path", board);
		
		assertFalse(elephant77.equals(squares[7][5].getPiece()));
		board.movePiece(elephant77,7,5);
		assertTrue(elephant77.equals(squares[7][5].getPiece()));
		
		printEnd("Move down two spaces with no pieces blocking path", board);
	}
	
	@Test 
	void moveLeftTwoSpacesWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Elephant(7, 7, Color.WHITE));
		Piece elephant77 = squares[7][7].getPiece();
		
		printStart("Move left two spaces with no pieces blocking path", board);
		
		assertFalse(elephant77.equals(squares[5][7].getPiece()));
		board.movePiece(elephant77,5,7);
		assertTrue(elephant77.equals(squares[5][7].getPiece()));
		
		printEnd("Move left two spaces with no pieces blocking path", board);
	}
	
	@Test
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[7][7].setPiece(new Elephant(7, 7, Color.WHITE));
		Piece elephant77 = squares[7][7].getPiece();
		squares[7][5].setPiece(new Queen(0, 7, Color.BLACK));
		
		printStart("Capture piece", board);
		
		assertFalse(elephant77.equals(squares[7][5].getPiece()));
		board.movePiece(elephant77,7,5);
		assertTrue(elephant77.equals(squares[7][5].getPiece()));
		
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
