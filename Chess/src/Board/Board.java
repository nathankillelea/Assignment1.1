package Board;
import Pieces.*;

/**
 * @author Nathan
 * Sources: https://stackoverflow.com/questions/29348496/creating-a-chess-board-with-system-out-println-in-java
 */

public class Board {
	
	private Square[][] board;
	private Color current_player;
	protected final int width = 8;
	protected final int height = 8;
	
	/**
	 * The constructor for the Board.
	 */
	public Board() {
		board = new Square [width][height];
		initializeBoard();
		initializePieces();
		current_player = Color.WHITE;
	}
	
	/**
	 * Parameterized constructor to allow for an empty board to be generated.
	 * 
	 * @param isEmpty This boolean parameter determines whether an empty board is generated.
	 */
	public Board(Boolean isEmpty) {
		if(isEmpty) {
			board = new Square [width][height];
			initializeBoard();
			current_player = Color.WHITE;
		}
		else {
			board = new Square [width][height];
			initializeBoard();
			initializePieces();
			current_player = Color.WHITE;	
		}
	}
	
	/**
	 * This is a helper function for the Board constructor. It sets up the squares on the board.
	 */
	private void initializeBoard() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				board[x][y] = new Square(x, y);
			}
		}
	}
	
	/**
	 * This is a helper function for the Board constructor. It Sets up the pieces on the board.
	 */
	private void initializePieces() {
		for(int x = 0; x < width; x++) {
			board[x][1].setPiece(new Pawn(x, 1, Color.WHITE));
			board[x][6].setPiece(new Pawn(x, 6, Color.BLACK));
		}
		
		board[0][0].setPiece(new Rook(0, 0, Color.WHITE));
		board[1][0].setPiece(new Knight(1, 0, Color.WHITE));
		board[2][0].setPiece(new Bishop(2, 0, Color.WHITE));
		board[3][0].setPiece(new Queen(3, 0, Color.WHITE));
		board[4][0].setPiece(new King(4, 0, Color.WHITE));
		board[5][0].setPiece(new Bishop(5, 0, Color.WHITE));
		board[6][0].setPiece(new Knight(6, 0, Color.WHITE));
		board[7][0].setPiece(new Rook(7, 0, Color.WHITE));
		
		board[0][7].setPiece(new Rook(0, 7, Color.BLACK));
		board[1][7].setPiece(new Knight(1, 7, Color.BLACK));
		board[2][7].setPiece(new Bishop(2, 7, Color.BLACK));
		board[3][7].setPiece(new Queen(3, 7, Color.BLACK));
		board[4][7].setPiece(new King(4, 7, Color.BLACK));
		board[5][7].setPiece(new Bishop(5, 7, Color.BLACK));
		board[6][7].setPiece(new Knight(6, 7, Color.BLACK));
		board[7][7].setPiece(new Rook(7, 7, Color.BLACK));
	}
	
	/**
	 * This function returns the board as a 2d array of squares.
	 * 
	 * @return Square[][] The board represented as a 2d array of squares.
	 */
	public Square[][] getSquares() {
		return board;
	}
	
	/**
	 * This function returns the color of the current player.
	 * 
	 * @return Color The color of the current player.
	 */
	public Color getCurrentPlayer() {
		return current_player;
	}
	
	/**
	 * This function returns the position of the king of the specified color. It is returned as an array [x,y].
	 * 
	 * @param board The board that should be checked
	 * @param color The color of the king that should be found
	 * @return int[] The position of the king.
	 */
	private int[] getKingPosition(Square[][] board, Color color) {
		int[] position_array = new int[2];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Piece generic_piece = board[x][y].getPiece();
				if(generic_piece instanceof King && generic_piece.getColor() == color) {
					position_array[0] = x;
					position_array[1] = y;
					break;
				}
			}
		}
		return position_array;
	}
	
	/**
	 * This function returns whether the current player is in a checkmate.
	 * 
	 * @return boolean This returns true if the current player is in checkmate or false if not.
	 */
	public boolean isCheckmate() {
		if(isNoLegalMoves() && isInCheck(board, current_player))
			return true;
		else
			return false;
	}
	
	/**
	 * This function returns whether the current player is in a stalemate (no legal moves and is not in check).
	 * 
	 * @return boolean This returns true if the current player is in a stalemate or false if not.
	 */
	public boolean isStalemate() {
		if(!isInCheck(board, current_player) && isNoLegalMoves())
			return true;
		else
			return false;
	}
	
	/**
	 * This function checks whether the current player has no legal moves.
	 * 
	 * @return boolean This returns true if there are no legal moves or false if not.
	 */
	public boolean isNoLegalMoves() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Piece generic_piece = board[x][y].getPiece();
				if(isNoLegalMoveForPiece(generic_piece) == false)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * This function checks if a piece has no legal moves
	 * 
	 * @param generic_piece The piece that is being checked
	 * @return boolean This returns true if there are no legal moves or false if not.
	 */
	public boolean isNoLegalMoveForPiece(Piece generic_piece) {
		if(generic_piece != null && generic_piece.getColor() == current_player) {
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					if(testMovePiece(generic_piece, x, y))
						return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This function checks whether the king of the specified color is in check.
	 * 
	 * @param board The board that should be checked
	 * @param color The color of the king that should be checked
	 * @return boolean This returns true if the king is in check or false if it is not.
	 */
	public boolean isInCheck(Square[][] board, Color color) {
		int[] king_position = getKingPosition(board, color);

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Piece generic_piece = board[x][y].getPiece();
				if(generic_piece != null && (generic_piece.getColor() != color)) {
					if(generic_piece.isValidMove(board, king_position[0], king_position[1]))
						return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This function makes a copy of the board (represented by a 2d array of squares).
	 * 
	 * @param board The board that should be copied
	 * @return Square[][] This returns a copy of the board.
	 */
	public Square[][] copyBoard(Square[][] board) {
		Square[][] copy = new Square [8][8];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				copy[x][y] = new Square(x, y);
				Piece generic_piece = board[x][y].getPiece();
				if(generic_piece != null)
					copy[x][y].setPiece(generic_piece);
			}
		}
		return copy;
	}
	
	/**
	 * This function changes the player to the player of the opposite color. It is called when a player's turn is over.
	 */
	private void changePlayer() {
		if(current_player == Color.WHITE)
			current_player = Color.BLACK;
		else
			current_player = Color.WHITE;
	}
	
	/**
	 * This function prints out the board.
	 */
	public void printBoard() {
		for(int y = (height-1); y >= 0; y--) {
		      System.out.println("");
		      System.out.println("---------------------------------");
			for(int x = 0; x < width; x++) {
				Piece generic_piece = board[x][y].getPiece();
				if(generic_piece == null)
					System.out.print("| " + " " + " ");
				else if(generic_piece.getColor() == Color.WHITE) {
					if(generic_piece instanceof King)
						System.out.print("| " + "♔" + "   ");
					else if(generic_piece instanceof Queen)
						System.out.print("| " + "♕" + "   ");
					else if(generic_piece instanceof Rook)
						System.out.print("| " + "♖" + "   ");
					else if(generic_piece instanceof Bishop)
						System.out.print("| " + "♗" + "   ");
					else if(generic_piece instanceof Knight)
						System.out.print("| " + "♘" + "   ");
					else if(generic_piece instanceof Pawn)
						System.out.print("| " + "♙" + "   ");
					else if(generic_piece instanceof Elephant)
						System.out.print("| " + "E" + " ");
					else if(generic_piece instanceof Giraffe)
						System.out.print("| " + "G" + " ");
				}
				else if(generic_piece.getColor() == Color.BLACK) {
					if(generic_piece instanceof King)
						System.out.print("| " + "♚" + "   ");
					else if(generic_piece instanceof Queen)
						System.out.print("| " + "♛" + "   ");
					else if(generic_piece instanceof Rook)
						System.out.print("| " + "♜" + "   ");
					else if(generic_piece instanceof Bishop)
						System.out.print("| " + "♝" + "   ");
					else if(generic_piece instanceof Knight)
						System.out.print("| " + "♞" + "   ");
					else if(generic_piece instanceof Pawn)
						System.out.print("| " + "♟" + "   ");
					else if(generic_piece instanceof Elephant)
						System.out.print("| " + "E" + " ");
					else if(generic_piece instanceof Giraffe)
						System.out.print("| " + "G" + " ");
				}
			}
		    System.out.print("|");
		}
		System.out.println("");
	    System.out.println("---------------------------------");
	}
	
	/**
	 * This function tests whether a given move is valid and if the player will put their king in check with the move.
	 * 
	 * @param piece The piece that is being tested
	 * @param dest_x The desired end x position of the piece
	 * @param dest_y The desired end y position of the piece
	 * @return boolean This returns true if the move will be valid and false if not.
	 */
	private boolean testMovePiece(Piece piece, int dest_x, int dest_y) {
		if(piece == null)
			return false;
		else if(piece.getColor() != current_player)
			return false;
		else if(piece.isValidMove(board, dest_x, dest_y)) {
			Square[][] board_copy = copyBoard(board);
			int start_x = piece.getX();
			int start_y = piece.getY();
			board_copy[dest_x][dest_y].removePiece();
			board_copy[dest_x][dest_y].setPiece(piece);
			board_copy[start_x][start_y].removePiece();
			if(isInCheck(board_copy, current_player))
				return false;
			else
				return true;
		}
		else
			return false;
	}
	
	/**
	 * This function attempts to move the piece to the desired position.
	 * 
	 * @param piece The piece that is trying to be moved
	 * @param dest_x The desired end x position of the piece
	 * @param dest_y The desired end y position of the piece
	 */
	public void movePiece(Piece piece, int dest_x, int dest_y) {
		if(testMovePiece(piece, dest_x, dest_y)) {
			int start_x = piece.getX();
			int start_y = piece.getY();
			board[dest_x][dest_y].removePiece();
			board[dest_x][dest_y].setPiece(piece);
			board[start_x][start_y].removePiece();
			piece.setPosition(dest_x, dest_y);
			changePlayer();
		}
	}
}
