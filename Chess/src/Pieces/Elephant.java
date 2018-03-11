package Pieces;

import Board.Square;

public class Elephant extends Piece {
	
	/**
	 * The constructor for an Elephant. The Elephant has the same moves as a Rook, but can only move up to 2 squares.
	 * 
	 * @param x_pos The Elephant's x position
	 * @param y_pos The Elephant's y position
	 * @param color The Elephant's color
	 */
	public Elephant(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(Math.abs(y_pos - end_y_pos) <= 2)
			return new Rook(x_pos, y_pos, color).isValidMove(board, end_x_pos, end_y_pos);
		else
			return false;
	}
}

