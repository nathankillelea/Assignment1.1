package Pieces;

import Board.Square;

/**
 * @author Nathan
 * Sources: https://www.youtube.com/watch?v=Bj6N0pEVC-I
 */

public abstract class Piece {
	
	protected int x_pos;
	protected int y_pos;
	protected Color color;
	
	/**
	 * The constructor for a Piece.
	 * 
	 * @param x_pos The Piece's x position
	 * @param y_pos The Piece's y position
	 * @param color The Piece's color
	 */
	public Piece(int x_pos, int y_pos, Color color) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.color = color;
	}
	
	/**
	 * This function sets the position of a Piece.
	 * 
	 * @param x_pos The Piece's x position
	 * @param y_pos The Piece's y position
	 */
	public void setPosition(int x_pos, int y_pos) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
	}
	
	/**
	 * This function returns the x position of the Piece.
	 * 
	 * @return int This returns the x position of the Piece.
	 */
	public int getX() {
		return x_pos;
	}
	
	/**
	 * This function returns the y position of the Piece.
	 * 
	 * @return int This returns the y position of the Piece.
	 */
	public int getY() {
		return y_pos;
	}
	
	/**
	 * This function returns the color of the Piece.
	 * 
	 * @return Color This returns the color of the Piece.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * This function checks the equality of two pieces.
	 * 
	 * @param other The piece that is being compared to.
	 * @return boolean This returns true if the pieces are equal and false if they are not
	 */
	public boolean equals(Piece other) {
		if(this == other)
			return true;
		if(other == null)
			return false;
		return (this.x_pos == other.x_pos && this.y_pos == other.y_pos && this.color == other.color);
	}
	
	/**
	 * This function checks if a move is valid for a Piece.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true or false whether the move is valid
	 */
	public abstract boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos);
	
	/**
	 * A function to check if a piece is making a universal bad move. These are moving OOB, not moving, and ending on a same color piece.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is moving OOB, not moving, or ending on a piece of the same color.
	 */
	public boolean isUniversalInvalidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingOutOfBounds(end_x_pos, end_y_pos))
			return true;
		else if(isStayingInPlace(end_x_pos, end_y_pos))
			return true;
		else if(isSameColor(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is moving out of bounds.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move out of bounds or false if not.
	 */
	public boolean isMovingOutOfBounds(int end_x_pos, int end_y_pos) {
		if((end_x_pos < 0) || (end_y_pos < 0) || (end_x_pos > 7) || (end_y_pos > 7))
			return true;
		else 
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to stay in place.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to stay in place or false if not.
	 */
	public boolean isStayingInPlace(int end_x_pos, int end_y_pos) {
		if((x_pos == end_x_pos) && (y_pos == end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to check if the square at the desired end x and y position is occupied by a piece of the same color.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the desired x and y position are occupied by a piece of the same color or false if not.
	 */
	public boolean isSameColor(Square[][] board, int end_x_pos, int end_y_pos) {
		Piece generic_piece = board[end_x_pos][end_y_pos].getPiece();
		if(generic_piece != null && generic_piece.getColor() == color)
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move right and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingRightAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingRight(end_x_pos, end_y_pos) && isPathRightClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move right.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move right or false if not.
	 */
	public boolean isMovingRight(int end_x_pos, int end_y_pos) {
		if(isMovingHorizontally(end_x_pos, end_y_pos) && (x_pos - end_x_pos < 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path right is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathRightClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos + 1; x < end_x_pos; x++) {
			if(board[x][end_y_pos].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move left and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingLeftAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingLeft(end_x_pos, end_y_pos) && isPathLeftClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move left.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move left or false if not.
	 */
	public boolean isMovingLeft(int end_x_pos, int end_y_pos) {
		if(isMovingHorizontally(end_x_pos, end_y_pos) && (x_pos - end_x_pos > 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path left is clear
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathLeftClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos - 1; x > end_x_pos; x--) {
			if(board[x][end_y_pos].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move horizontally.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move horizontally or false if not.
	 */
	public boolean isMovingHorizontally(int end_x_pos, int end_y_pos) {
		if((y_pos == end_y_pos) && (x_pos != end_x_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move up and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingUpAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingUp(end_x_pos, end_y_pos) && isPathUpClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move up.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move up or false if not.
	 */
	public boolean isMovingUp(int end_x_pos, int end_y_pos) {
		if(isMovingVertically(end_x_pos, end_y_pos) && (y_pos - end_y_pos < 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path up is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired x position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathUpClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int y = y_pos + 1; y < end_y_pos; y++) {
			if(board[end_x_pos][y].getPiece() != null)
				return false;			
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move down and if the path is clear to do so.
	 * 
	 * @param board  The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingDownAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingDown(end_x_pos, end_y_pos) && isPathDownClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move down.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move down or false if not.
	 */
	public boolean isMovingDown(int end_x_pos, int end_y_pos) {
		if(isMovingVertically(end_x_pos, end_y_pos) && (y_pos - end_y_pos > 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path down is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathDownClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int y = y_pos - 1; y > end_y_pos; y--) {
			if(board[end_x_pos][y].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move vertically.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move vertically or false if not. 
	 */
	public boolean isMovingVertically(int end_x_pos, int end_y_pos) {
		if((x_pos == end_x_pos) && (y_pos != end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally up and right and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingDiagonallyUpAndRightAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingDiagonallyUpAndRight(end_x_pos, end_y_pos) && isPathDiagonallyUpAndRightClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally up and right.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move diagonally up and right or false if not.
	 */
	public boolean isMovingDiagonallyUpAndRight(int end_x_pos, int end_y_pos) {
		if(isMovingDiagonally(end_x_pos, end_y_pos) && (y_pos - end_y_pos < 0) && (x_pos - end_x_pos < 0))
			return true;
		else
			return false;
	}
	/**
	 * A function to determine if the path diagonally up and right is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathDiagonallyUpAndRightClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos + 1, y = y_pos + 1; x < end_x_pos; x++, y++) {
			if(board[x][y].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally up and left and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingDiagonallyUpAndLeftAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingDiagonallyUpAndLeft(end_x_pos, end_y_pos) && isPathDiagonallyUpAndLeftClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally up and left.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move diagonally up and left or false if not.
	 */
	public boolean isMovingDiagonallyUpAndLeft(int end_x_pos, int end_y_pos) {
		if(isMovingDiagonally(end_x_pos, end_y_pos) && (y_pos - end_y_pos < 0) && (x_pos - end_x_pos > 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path diagonally up and left is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathDiagonallyUpAndLeftClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos - 1, y = y_pos + 1; x > end_x_pos; x--, y++) {
			if(board[x][y].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally down and right and if the path is clear to do so.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingDiagonallyDownAndRightAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingDiagonallyDownAndRight(end_x_pos, end_y_pos) && isPathDiagonallyDownAndRightClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally down and right.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move diagonally down and right or false if not.
	 */
	public boolean isMovingDiagonallyDownAndRight(int end_x_pos, int end_y_pos) {
		if(isMovingDiagonally(end_x_pos, end_y_pos) && (y_pos - end_y_pos > 0) && (x_pos - end_x_pos < 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path diagonally down and right is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathDiagonallyDownAndRightClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos + 1, y = y_pos - 1; x < end_x_pos; x++, y--) {
			if(board[x][y].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * This function checks whether the piece is trying to move diagonally down and left and whether the path is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if both conditions hold or false if not.
	 */
	public boolean isMovingDiagonallyDownAndLeftAndPathIsClear(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isMovingDiagonallyDownAndLeft(end_x_pos, end_y_pos) && isPathDiagonallyDownAndLeftClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally down and left.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move diagonally down and left or false if not.
	 */
	public boolean isMovingDiagonallyDownAndLeft(int end_x_pos, int end_y_pos) {
		if(isMovingDiagonally(end_x_pos, end_y_pos) && (y_pos - end_y_pos > 0) && (x_pos - end_x_pos > 0))
			return true;
		else
			return false;
	}
	
	/**
	 * A function to determine if the path diagonally down and left is clear.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the path is clear or false if not.
	 */
	public boolean isPathDiagonallyDownAndLeftClear(Square[][] board, int end_x_pos, int end_y_pos) {
		for(int x = x_pos - 1, y = y_pos - 1; x > end_x_pos; x--, y--) {
			if(board[x][y].getPiece() != null)
				return false;
		}
		return true;
	}
	
	/**
	 * A function to determine if the piece is trying to move diagonally.
	 * 
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the piece is trying to move diagonally or false if not.
	 */
	public boolean isMovingDiagonally(int end_x_pos, int end_y_pos) {
		if(Math.abs(x_pos - end_x_pos) == Math.abs(y_pos - end_y_pos))
			return true;
		else
			return false;
	}
	
}
