package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class BishopTests {
	
	@Test
	void moveDiagonallyWithSameColorPieceBlockingPath() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece bishop20 = squares[2][0].getPiece();
		
		printStart("Move diagonally with same color piece blocking path", board);
		
		assertFalse(bishop20.equals(squares[4][2].getPiece()));
		board.movePiece(bishop20,4,2);
		assertFalse(bishop20.equals(squares[4][2].getPiece()));
		
		printEnd("Move diagonally with same color piece blocking path", board);
	}
	
	@Test
	void moveHorizontallyWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[2][0].setPiece(new Bishop(2, 0, Color.WHITE));
		Piece bishop20 = squares[2][0].getPiece();
		
		printStart("Move horizontally with no pieces blocking path", board);
		
		assertFalse(bishop20.equals(squares[4][0].getPiece()));
		board.movePiece(bishop20,4,0);
		assertFalse(bishop20.equals(squares[4][0].getPiece()));
		
		printEnd("Move horizontally with no pieces blocking path", board);
	}
	
	@Test
	void moveVerticallyWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[2][0].setPiece(new Bishop(2, 0, Color.WHITE));
		Piece bishop20 = squares[2][0].getPiece();
		
		printStart("Move vertically with no pieces blocking path", board);
		
		assertFalse(bishop20.equals(squares[2][4].getPiece()));
		board.movePiece(bishop20,2,4);
		assertFalse(bishop20.equals(squares[2][4].getPiece()));
		
		printEnd("Move vertically with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonallyWithNoPiecesBlockingPath() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[2][0].setPiece(new Bishop(2, 0, Color.WHITE));
		Piece bishop20 = squares[2][0].getPiece();
		
		printStart("Move diagonally with no pieces blocking path", board);
		
		assertFalse(bishop20.equals(squares[4][2].getPiece()));
		board.movePiece(bishop20,4,2);
		assertTrue(bishop20.equals(squares[4][2].getPiece()));
		
		printEnd("Move diagonally with no pieces blocking path", board);
	}
	
	@Test
	void captureEnemyPiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[2][0].setPiece(new Bishop(2, 0, Color.WHITE));
		Piece bishop20 = squares[2][0].getPiece();
		squares[4][2].setPiece(new Queen(4, 2, Color.BLACK));
		
		printStart("Capture enemy piece", board);
		
		assertFalse(bishop20.equals(squares[4][2].getPiece()));
		board.movePiece(bishop20,4,2);
		assertTrue(bishop20.equals(squares[4][2].getPiece()));
		
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
