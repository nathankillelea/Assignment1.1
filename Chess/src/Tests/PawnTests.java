package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.Board;
import Board.Square;
import Pieces.*;

class PawnTests {
	
	@Test 
	void moveRight() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][1].setPiece(new Pawn(0, 1, Color.WHITE));
		Piece pawn01 = squares[0][1].getPiece();
		
		printStart("Move right with no pieces blocking path", board);
		
		assertFalse(pawn01.equals(squares[1][1].getPiece()));
		board.movePiece(pawn01,1,1);
		assertFalse(pawn01.equals(squares[1][1].getPiece()));
		
		printEnd("Move right with no pieces blocking path", board);
	}
	
	@Test
	void moveDiagonalWithNoPieceToCapture() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[1][4].setPiece(new Pawn(1, 4, Color.WHITE));
		Piece pawn14 = squares[1][4].getPiece();
		
		printStart("Move diagonal with no piece to capture", board);

		assertFalse(pawn14.equals(squares[0][5].getPiece()));
		board.movePiece(pawn14,0,5);
		assertFalse(pawn14.equals(squares[0][5].getPiece()));
		
		printEnd("Move diagonal with no piece to capture", board);
	}
	
	@Test 
	void moveWhiteBackwards() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][1].setPiece(new Pawn(0, 1, Color.WHITE));
		Piece pawn01 = squares[0][1].getPiece();
		
		printStart("Move white backwards", board);
		
		assertFalse(pawn01.equals(squares[0][0].getPiece()));
		board.movePiece(pawn01,0,0);
		assertFalse(pawn01.equals(squares[0][0].getPiece()));
		
		printEnd("Move white backwards", board);
	}
	
	@Test 
	void moveBlackBackwards() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[0][6].setPiece(new Pawn(0, 6, Color.BLACK));
		Piece pawn01 = squares[0][6].getPiece();
		
		printStart("Move black backwards", board);
		
		assertFalse(pawn01.equals(squares[0][7].getPiece()));
		board.movePiece(pawn01,0,7);
		assertFalse(pawn01.equals(squares[0][7].getPiece()));
		
		printEnd("Move black backwards", board);
	}
	
	@Test 
	void moveWhiteUpOneSquareWithNoPiecesBlockingPath() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece pawn01 = squares[0][1].getPiece();
		
		printStart("Move white up one square with no pieces blocking path", board);
		
		assertFalse(pawn01.equals(squares[0][2].getPiece()));
		board.movePiece(pawn01,0,2);
		assertTrue(pawn01.equals(squares[0][2].getPiece()));
		
		printEnd("Move white up one square with no pieces blocking path", board);
	}
	
	@Test 
	void moveWhiteUpTwoSquaresWithNoPiecesBlockingPath() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece pawn01 = squares[0][1].getPiece();
		
		printStart("Move white up two squares with no pieces blocking path", board);
		
		assertFalse(pawn01.equals(squares[0][3].getPiece()));
		board.movePiece(pawn01,0,3);
		assertTrue(pawn01.equals(squares[0][3].getPiece()));
		
		printEnd("Move white up two squares with no pieces blocking path", board);
	}

	@Test 
	void moveWhiteUpTwoSquaresAfterFirstMove() {
		Board board = new Board();
		Square[][] squares = board.getSquares();
		Piece pawn01 = squares[0][1].getPiece();
		Piece pawn16 = squares[1][6].getPiece();
		board.movePiece(pawn01,0,3);		
		board.movePiece(pawn16,1,5);
		
		printStart("Move white up two squares after first move", board);

		assertFalse(pawn01.equals(squares[0][5].getPiece()));
		board.movePiece(pawn01,0,5);
		assertFalse(pawn01.equals(squares[0][5].getPiece()));
		
		printEnd("Move white up two squares after first move", board);
	}
	
	@Test 
	void whiteCaptureBlackPiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[1][4].setPiece(new Pawn(1, 4, Color.WHITE));
		Piece pawn14 = squares[1][4].getPiece();
		squares[0][5].setPiece(new Rook(0, 5, Color.BLACK));
		
		printStart("White capture black piece", board);

		assertFalse(pawn14.equals(squares[0][5].getPiece()));
		board.movePiece(pawn14,0,5);
		assertTrue(pawn14.equals(squares[0][5].getPiece()));
		
		printEnd("White capture black piece", board);
	}
	
	@Test 
	void blackCaptureWhitePiece() {
		Board board = new Board(true);
		Square[][] squares = board.getSquares();
		squares[1][3].setPiece(new Pawn(1, 3, Color.WHITE));
		Piece pawn13 = squares[1][3].getPiece();
		squares[0][5].setPiece(new Pawn(0, 5, Color.BLACK));
		Piece pawn05 = squares[0][5].getPiece();
		board.movePiece(pawn13,1,4);
		
		printStart("Black capture white piece", board);

		assertFalse(pawn05.equals(squares[1][4].getPiece()));
		board.movePiece(pawn05,1,4);
		assertTrue(pawn05.equals(squares[1][4].getPiece()));
		
		printEnd("Black capture white piece", board);
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
