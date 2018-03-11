package Board;
import Pieces.Piece;

public class Square {
	
	private int x_pos;
	private int y_pos;
	private Piece occupying_piece;
	
	/**
	 * The constructor for a square.
	 * 
	 * @param x_pos The Square's x position
	 * @param y_pos The Square's y position
	 */
	public Square(int x_pos, int y_pos) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		
		// null == No piece is occupying the square.
		occupying_piece = null;
	}
	
	/**
	 * This function returns the piece that occupies the square.
	 * 
	 * @return Piece This returns the piece that occupies the square.
	 */
	public Piece getPiece() {
		return occupying_piece;
	}
	
	/**
	 * This function sets the specified new piece to occupy the current square.
	 * 
	 * @param new_piece This is the piece that is set to the current square.
	 */
	public void setPiece(Piece new_piece) {
		occupying_piece = new_piece;
	}
	
	/**
	 * This function returns the x coordinate of the square.
	 * 
	 * @return int This returns the x coordinate of the square.
	 */
	public int getX() {
		return x_pos;
	}
	
	/**
	 * This function returns the y coordinate of the square.
	 * 
	 * @return int This returns the y coordinate of the square.
	 */
	public int getY() {
		return y_pos;
	}
	
	/**
	 * This function sets the square to be null so that no piece is on it.
	 */
	public void removePiece() {
		occupying_piece = null;
	}
}
