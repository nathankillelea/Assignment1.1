package Pieces;

import Board.Square;

public class Pawn extends Piece {
	
	private boolean first_move;
	
	/**
	 * The constructor for a Pawn.
	 * 
	 * @param x_pos The Pawn's x position
	 * @param y_pos The Pawn's y position
	 * @param color The Pawn's color
	 */
	public Pawn(int x_pos, int y_pos, Color color) {
		super(x_pos, y_pos, color);
		first_move = true;
	}
	
	public boolean isValidMove(Square[][] board, int end_x_pos, int end_y_pos) {
		if(isUniversalInvalidMove(board, end_x_pos, end_y_pos))
			return false;
		else if(color == Color.WHITE) {
			if(isMovingUp(end_x_pos, end_y_pos))
				return isValidMoveUp(board, end_x_pos, end_y_pos);
			else if((isMovingDiagonallyUpAndRight(end_x_pos, end_y_pos) || 
					isMovingDiagonallyUpAndLeft (end_x_pos, end_y_pos)) && (Math.abs(x_pos - end_x_pos) == 1)) {
				return isPieceOnSpace(board, end_x_pos, end_y_pos); // Guaranteed to be an enemy as isUniversalInvalidMove() did not fail
			}
			else
				return false;
		}
		else if(color == Color.BLACK) {
			if(isMovingDown(end_x_pos, end_y_pos)) 
				return isValidMoveDown(board, end_x_pos, end_y_pos);
			else if((isMovingDiagonallyDownAndRight(end_x_pos, end_y_pos) || 
					isMovingDiagonallyDownAndLeft (end_x_pos, end_y_pos)) && (Math.abs(x_pos - end_x_pos) == 1)) {
				return isPieceOnSpace(board, end_x_pos, end_y_pos); // Guaranteed to be an enemy as isUniversalInvalidMove() did not fail
			}
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * This function checks whether the move upwards is valid for the pawn.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the move is valid or false if not.
	 */
	private boolean isValidMoveUp(Square[][] board, int end_x_pos, int end_y_pos) {
		if((first_move == true) && (Math.abs(y_pos - end_y_pos) <= 2)) {
			if((isPathUpClear(board, end_x_pos, end_y_pos)) && (board[end_x_pos][end_y_pos].getPiece() == null)) {
				first_move = false;
				return true;
			}
			else
				return false;
		}
		else if(first_move == false && (Math.abs(y_pos - end_y_pos) == 1)) {
			if(board[end_x_pos][end_y_pos].getPiece() == null)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * This function checks whether the move downwards is valid for the pawn.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the move is valid or false if not.
	 */
	private boolean isValidMoveDown(Square[][] board, int end_x_pos, int end_y_pos) {
		if(first_move == true && (Math.abs(y_pos - end_y_pos) <= 2)) {
			if(isPathDownClear(board, end_x_pos, end_y_pos) && (board[end_x_pos][end_y_pos].getPiece() == null)) {
				first_move = false;
				return true;
			}
			else
				return false;
		}
		else if(first_move == false && (Math.abs(y_pos - end_y_pos) == 1)) {
			if(board[end_x_pos][end_y_pos].getPiece() == null)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * This function checks whether the space is occupied by a piece.
	 * 
	 * @param board The board that is being used
	 * @param end_x_pos The desired x position of the piece
	 * @param end_y_pos The desired y position of the piece
	 * @return boolean This returns true if the space is occupied by a piece
	 */
	private boolean isPieceOnSpace(Square[][] board, int end_x_pos, int end_y_pos) {
		if(board[end_x_pos][end_y_pos].getPiece() != null) {
			if(first_move == true) {first_move = false;}
			return true;
		}
		else
			return false;
	}
	
}
