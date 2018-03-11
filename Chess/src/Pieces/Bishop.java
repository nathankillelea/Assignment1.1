package Pieces;

import Board.Square;

public class Bishop extends Piece {
	
	/**
	 * The constructor for a Bishop.
	 * 
	 * @param x_pos The Bishop's x position
	 * @param y_pos The Bishop's y position
	 * @param color The Bishop's color
	 */
	public Bishop(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isUniversalInvalidMove(board, end_x_pos, end_y_pos))
			return false;
		else if(isMovingDiagonallyUpAndRightAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingDiagonallyUpAndLeftAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingDiagonallyDownAndRightAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else if(isMovingDiagonallyDownAndLeftAndPathIsClear(board, end_x_pos, end_y_pos))
			return true;
		else
			return false;
	}
	
}
