package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class QueenTests {
	
	@Test 
	void moveUpTwoSquaresWithPieceBlockingPath() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece queen30 = squares[3][0].getPiece();
		
		printStart("Move up two spaces with a piece blocking path", board);
		
		assertFalse(queen30.equals(squares[3][2].getPiece()));
		board.movePiece(queen30,3,2);
		assertFalse(queen30.equals(squares[3][2].getPiece()));
		
		printEnd("Move up two spaces with a piece blocking path", board);
	}
	
	@Test
	void strangeMove() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		Piece queen = squares[3][0].getPiece();
		
		printStart("Perform a strange move", board);
		
		assertFalse(queen.equals(squares[4][5].getPiece()));
		board.movePiece(queen,4,5);
		assertFalse(queen.equals(squares[4][5].getPiece()));
		
		printEnd("Perform a strange move", board);
	}
	
	@Test 
	void moveUpTwoSquaresWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		Piece queen = squares[3][0].getPiece();
		
		printStart("Move up two squares with no pieces blocking path", board);
		
		assertFalse(queen.equals(squares[3][2].getPiece()));
		board.movePiece(queen,3,2);
		assertTrue(queen.equals(squares[3][2].getPiece()));
		
		printEnd("Move up two squares with no pieces blocking path", board);
	}
	
	@Test 
	void moveRightTwoSquaresWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		Piece queen = squares[3][0].getPiece();
		
		printStart("Move right two squares with no pieces blocking path", board);
		
		assertFalse(queen.equals(squares[5][0].getPiece()));
		board.movePiece(queen,5,0);
		assertTrue(queen.equals(squares[5][0].getPiece()));
		
		printEnd("Move up two squares with no pieces blocking path", board);
	}
	
	@Test 
	void moveDiagonallyTwoSquaresWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		Piece queen = squares[3][0].getPiece();
		
		printStart("Move diagonally two squares with no pieces blocking path", board);
		
		assertFalse(queen.equals(squares[5][2].getPiece()));
		board.movePiece(queen,5,2);
		assertTrue(queen.equals(squares[5][2].getPiece()));
		
		printEnd("Move diagonally two squares with no pieces blocking path", board);
	}
	
	@Test 
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		Piece queen = squares[3][0].getPiece();
		squares[5][2].setPiece(new Queen(5, 2, Color.BLACK));
		
		printStart("Capture piece", board);
		
		assertFalse(queen.equals(squares[5][2].getPiece()));
		board.movePiece(queen,5,2);
		assertTrue(queen.equals(squares[5][2].getPiece()));
		
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
