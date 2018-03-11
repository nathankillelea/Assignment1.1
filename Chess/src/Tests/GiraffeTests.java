package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class GiraffeTests {

	@Test
	void moveDiagonalOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		
		printStart("Move diagonal one square", board);
		
		assertFalse(giraffe.equals(squares[4][4].getPiece()));
		board.movePiece(giraffe,4,4);
		assertFalse(giraffe.equals(squares[4][4].getPiece()));
		
		printEnd("Move diagonal one square", board);
	}
	
	@Test
	void moveUpFourAndLeftOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		
		printStart("Move up four squares and left one", board);
		
		assertFalse(giraffe.equals(squares[2][7].getPiece()));
		board.movePiece(giraffe,2,7);
		assertTrue(giraffe.equals(squares[2][7].getPiece()));
		
		printEnd("Move up four squares and left one", board);
	}
	
	@Test
	void moveUpFourAndRightOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		
		printStart("Move up four squares and right one", board);
		
		assertFalse(giraffe.equals(squares[4][7].getPiece()));
		board.movePiece(giraffe,4,7);
		assertTrue(giraffe.equals(squares[4][7].getPiece()));
		
		printEnd("Move up four squares and right one", board);
	}
	
	@Test
	void moveDownFourAndLeftOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new Giraffe(4, 4, Color.WHITE));
		Piece giraffe = squares[4][4].getPiece();
		
		printStart("Move down four squares and left one", board);
		
		assertFalse(giraffe.equals(squares[3][0].getPiece()));
		board.movePiece(giraffe,3,0);
		assertTrue(giraffe.equals(squares[3][0].getPiece()));
		
		printEnd("Move down four squares and left one", board);
	}
	
	@Test
	void moveDownFourAndRightOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new Giraffe(4, 4, Color.WHITE));
		Piece giraffe = squares[4][4].getPiece();
		
		printStart("Move down four squares and right one", board);
		
		assertFalse(giraffe.equals(squares[5][0].getPiece()));
		board.movePiece(giraffe,5,0);
		assertTrue(giraffe.equals(squares[5][0].getPiece()));
		
		printEnd("Move down four squares and right one", board);
	}
	
	@Test
	void moveRightFourAndUpOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		
		printStart("Move right four squares and up one", board);
		
		assertFalse(giraffe.equals(squares[7][4].getPiece()));
		board.movePiece(giraffe,7,4);
		assertTrue(giraffe.equals(squares[7][4].getPiece()));
		
		printEnd("Move right four squares and up one", board);
	}
	
	@Test
	void moveRightFourAndDownOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		
		printStart("Move right four squares and down one", board);
		
		assertFalse(giraffe.equals(squares[7][2].getPiece()));
		board.movePiece(giraffe,7,2);
		assertTrue(giraffe.equals(squares[7][2].getPiece()));
		
		printEnd("Move right four squares and down one", board);
	}
	
	@Test
	void moveLeftFourAndUpOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new Giraffe(4, 4, Color.WHITE));
		Piece giraffe = squares[4][4].getPiece();
		
		printStart("Move left four squares and up one", board);
		
		assertFalse(giraffe.equals(squares[0][5].getPiece()));
		board.movePiece(giraffe,0,5);
		assertTrue(giraffe.equals(squares[0][5].getPiece()));
		
		printEnd("Move left four squares and up one", board);
	}
	
	@Test
	void moveLeftFourAndDownOneSquare() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[4][4].setPiece(new Giraffe(4, 4, Color.WHITE));
		Piece giraffe = squares[4][4].getPiece();
		
		printStart("Move left four squares and down one", board);
		
		assertFalse(giraffe.equals(squares[0][3].getPiece()));
		board.movePiece(giraffe,0,3);
		assertTrue(giraffe.equals(squares[0][3].getPiece()));
		
		printEnd("Move left four squares and down one", board);
	}
	
	@Test
	void capturePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		squares[4][7].setPiece(new Pawn(1, 2, Color.BLACK));
		
		printStart("Capture piece", board);
		
		assertFalse(giraffe.equals(squares[4][7].getPiece()));
		board.movePiece(giraffe,4,7);
		assertTrue(giraffe.equals(squares[4][7].getPiece()));
		
		printEnd("Capture piece", board);
	}
	
	@Test
	void leapOverPiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[3][3].setPiece(new Giraffe(3, 3, Color.WHITE));
		Piece giraffe = squares[3][3].getPiece();
		squares[4][5].setPiece(new Pawn(1, 2, Color.BLACK));
		
		printStart("Leap over piece", board);
		
		assertFalse(giraffe.equals(squares[4][7].getPiece()));
		board.movePiece(giraffe,4,7);
		assertTrue(giraffe.equals(squares[4][7].getPiece()));
		
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
