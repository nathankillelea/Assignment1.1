package Pieces;

import Board.Square;

public class Knight extends Piece {
	
	/**
	 * The constructor for a Knight.
	 * 
	 * @param x_pos The Knight's x position
	 * @param y_pos The Knight's y position
	 * @param color The Knight's color
	 */
	public Knight(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isUniversalInvalidMove(board, end_x_pos, end_y_pos))
			return false;
		else if((Math.abs(x_pos - end_x_pos) == 2) && (Math.abs(y_pos - end_y_pos) == 1))
			return true;
		else if((Math.abs(x_pos - end_x_pos) == 1) && (Math.abs(y_pos - end_y_pos) == 2))
			return true;
		else
			return false;
	}
}
