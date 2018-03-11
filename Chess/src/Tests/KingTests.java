package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class KingTests {

	@Test 
	void moveUpTwoSquaresWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][0].setPiece(new King(4, 0, Color.WHITE));
		Piece king40 = squares[4][0].getPiece();
		
		printStart("Move up two spaces with no pieces blocking path", board);
		
		assertFalse(king40.equals(squares[4][2].getPiece()));
		board.movePiece(king40,4,2);
		assertFalse(king40.equals(squares[4][2].getPiece()));
		
		printEnd("Move up two spaces with no pieces blocking path", board);
	}
	
	@Test
	void moveUpOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move up one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[4][5].getPiece()));
		board.movePiece(king,4,5);
		assertTrue(king.equals(squares[4][5].getPiece()));
		
		printEnd("Move up one square with no pieces blocking path", board);
	}
	
	@Test
	void moveDownOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move down one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[4][3].getPiece()));
		board.movePiece(king,4,3);
		assertTrue(king.equals(squares[4][3].getPiece()));
		
		printEnd("Move down one square with no pieces blocking path", board);
	}
	
	@Test
	void moveLeftOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move left one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[3][4].getPiece()));
		board.movePiece(king,3,4);
		assertTrue(king.equals(squares[3][4].getPiece()));
		
		printEnd("Move left one square with no pieces blocking path", board);
	}
	
	@Test
	void moveRightOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move right one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[5][4].getPiece()));
		board.movePiece(king,5,4);
		assertTrue(king.equals(squares[5][4].getPiece()));
		
		printEnd("Move right one square with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonallyUpAndRightOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move diagonally up and right one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[5][5].getPiece()));
		board.movePiece(king,5,5);
		assertTrue(king.equals(squares[5][5].getPiece()));
		
		printEnd("Move diagonally up and right one square with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonallyUpAndLeftOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move diagonally up and left one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[3][5].getPiece()));
		board.movePiece(king,3,5);
		assertTrue(king.equals(squares[3][5].getPiece()));
		
		printEnd("Move diagonally up and left one square with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonallyDownAndRightOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move diagonally down and right one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[5][3].getPiece()));
		board.movePiece(king,5,3);
		assertTrue(king.equals(squares[5][3].getPiece()));
		
		printEnd("Move diagonally down and right one square with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonallyDownAndLeftOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new King(4, 4, Color.WHITE));
		Piece king = squares[4][4].getPiece();
		
		printStart("Move diagonally down and left one square with no pieces blocking path", board);
		
		assertFalse(king.equals(squares[3][3].getPiece()));
		board.movePiece(king,3,3);
		assertTrue(king.equals(squares[3][3].getPiece()));
		
		printEnd("Move diagonally down and left one square with no pieces blocking path", board);
	}
	
	@Test
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][0].setPiece(new King(4, 0, Color.WHITE));
		Piece king40 = squares[4][0].getPiece();
		squares[4][1].setPiece(new Pawn(4, 1, Color.BLACK));
		
		printStart("Capture enemy piece", board);
		
		assertFalse(king40.equals(squares[4][1].getPiece()));
		board.movePiece(king40,4,1);
		assertTrue(king40.equals(squares[4][1].getPiece()));
		
		printEnd("Capture enemy piece", board);
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
