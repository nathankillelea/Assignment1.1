package Pieces;

import Board.Square;

public class Rook extends Piece {
	
	/**
	 * The constructor for a Rook.
	 * 
	 * @param x_pos The Rook's x position
	 * @param y_pos The Rook's y position
	 * @param color The Rook's color
	 */
	public Rook(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isUniversalInvalidMove(board, end_x_pos, end_y_pos))
			return false;
		else if(isMovingDownAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingUpAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingLeftAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingRightAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
}
