package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class KnightTests {
	
	@Test
	void moveDiagonalOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move diagonal one square", board);
		
		assertFalse(knight.equals(squares[4][4].getPiece()));
		board.movePiece(knight,4,4);
		assertFalse(knight.equals(squares[4][4].getPiece()));
		
		printEnd("Move diagonal one square", board);
	}
	
	@Test
	void moveUpTwoAndLeftOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move up two squares and left one", board);
		
		assertFalse(knight.equals(squares[2][5].getPiece()));
		board.movePiece(knight,2,5);
		assertTrue(knight.equals(squares[2][5].getPiece()));
		
		printEnd("Move up two squares and left one", board);
	}
	
	@Test
	void moveUpTwoAndRightOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move up two squares and right one", board);
		
		assertFalse(knight.equals(squares[4][5].getPiece()));
		board.movePiece(knight,4,5);
		assertTrue(knight.equals(squares[4][5].getPiece()));
		
		printEnd("Move up two squares and right one", board);
	}
	
	@Test
	void moveDownTwoAndLeftOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move down two squares and left one", board);
		
		assertFalse(knight.equals(squares[2][1].getPiece()));
		board.movePiece(knight,2,1);
		assertTrue(knight.equals(squares[2][1].getPiece()));
		
		printEnd("Move down two squares and left one", board);
	}
	
	@Test
	void moveDownTwoAndRightOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move down two squares and right one", board);
		
		assertFalse(knight.equals(squares[4][1].getPiece()));
		board.movePiece(knight,4,1);
		assertTrue(knight.equals(squares[4][1].getPiece()));
		
		printEnd("Move down two squares and right one", board);
	}
	
	@Test
	void moveRightTwoAndUpOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move right two squares and up one", board);
		
		assertFalse(knight.equals(squares[5][4].getPiece()));
		board.movePiece(knight,5,4);
		assertTrue(knight.equals(squares[5][4].getPiece()));
		
		printEnd("Move right two squares and up one", board);
	}
	
	@Test
	void moveRightTwoAndDownOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move right two squares and down one", board);
		
		assertFalse(knight.equals(squares[5][2].getPiece()));
		board.movePiece(knight,5,2);
		assertTrue(knight.equals(squares[5][2].getPiece()));
		
		printEnd("Move right two squares and down one", board);
	}
	
	@Test
	void moveLeftTwoAndUpOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move left two squares and up one", board);
		
		assertFalse(knight.equals(squares[1][4].getPiece()));
		board.movePiece(knight,1,4);
		assertTrue(knight.equals(squares[1][4].getPiece()));
		
		printEnd("Move left two squares and up one", board);
	}
	
	@Test
	void moveLeftTwoAndDownOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		
		printStart("Move left two squares and down one", board);
		
		assertFalse(knight.equals(squares[1][2].getPiece()));
		board.movePiece(knight,1,2);
		assertTrue(knight.equals(squares[1][2].getPiece()));
		
		printEnd("Move left two squares and down one", board);
	}
	
	@Test
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Knight(3, 3, Color.WHITE));
		Piece knight = squares[3][3].getPiece();
		squares[1][2].setPiece(new Pawn(1, 2, Color.BLACK));
		
		printStart("Capture piece", board);
		
		assertFalse(knight.equals(squares[1][2].getPiece()));
		board.movePiece(knight,1,2);
		assertTrue(knight.equals(squares[1][2].getPiece()));
		
		printEnd("Capture piece", board);
	}
	
	@Test
	void leapOverPiece() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece knight10 = squares[1][0].getPiece();
		
		printStart("Leap over piece", board);
		
		assertFalse(knight10.equals(squares[2][2].getPiece()));
		board.movePiece(knight10,2,2);
		assertTrue(knight10.equals(squares[2][2].getPiece()));
		
		printEnd("Leap over piece", board);
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
