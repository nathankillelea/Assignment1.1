package Pieces;

import Board.Square;

public class King extends Piece {
	
	/**
	 * The constructor for a King.
	 * 
	 * @param x_pos The King's x position
	 * @param y_pos The King's y position
	 * @param color The King's color
	 */
	public King(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isUniversalInvalidMove(board, end_x_pos, end_y_pos))
			return false;
		else if((Math.abs(x_pos - end_x_pos) == 1) && (Math.abs(y_pos - end_y_pos) == 1))
			return true;
		else if((Math.abs(x_pos - end_x_pos) == 0) && (Math.abs(y_pos - end_y_pos) == 1))
			return true;
		else if((Math.abs(x_pos - end_x_pos) == 1) && (Math.abs(y_pos - end_y_pos) == 0))
			return true;
		else
			return false;
	}
}
