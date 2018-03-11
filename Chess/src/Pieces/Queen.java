package Pieces;

import Board.Square;

public class Queen extends Piece {
	
	/**
	 * The constructor for a Queen.
	 * 
	 * @param x_pos The Queen's x position
	 * @param y_pos The Queen's y position
	 * @param color The Queen's color
	 */
	public Queen(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		return new Rook(x_pos, y_pos, color).isValidMove(board, end_x_pos, end_y_pos) || 
			   new Bishop(x_pos, y_pos, color).isValidMove(board, end_x_pos, end_y_pos);
	}
	
}
