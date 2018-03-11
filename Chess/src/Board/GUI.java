// https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui

package Board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI {
	
	private final JPanel gui = new JPanel(new BorderLayout(3,3));
	private JButton[][] boardSquares = new JButton[8][8];
	private JPanel board;
	
	/**
	 * This is the constructor for the GUI class. It simply calls the initGUI and setUpNewBoard functions and sets up the main JFrame window.
	 */
	public GUI() {
		initBoard();
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		JFrame window = new JFrame("Chess");
		window.add(gui);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationByPlatform(true);
		window.pack();
		window.setMinimumSize(window.getSize());
		window.setVisible(true);
	}
	
	/**
	 * This function initializes the GUI by creating the board as a grid layout and creating JButtons for every square
	 * on the grid.
	 */
	private void initBoard() {
		board = new JPanel(new GridLayout(0, 8));
		board.setBorder(new LineBorder(Color.BLACK));
		gui.add(board);
		setUpSquares();
		setUpPieces();
	}
	
	/**
	 * This function sets up the squares as clickable buttons.
	 */
	private void setUpSquares() {
		for(int i = 0; i < boardSquares.length; i++) {
			for(int j = 0; j < boardSquares[i].length; j++) {
				JButton button = new JButton();
				button.setMargin(new Insets(0, 0, 0, 0));
				ImageIcon icon = new ImageIcon(new BufferedImage(45, 45, BufferedImage.TYPE_INT_ARGB));
				button.setIcon(icon);
				if((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0))
					button.setBackground(Color.WHITE);
				else
					button.setBackground(Color.LIGHT_GRAY);
				boardSquares[j][i] = button;
			}
		}
		
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				board.add(boardSquares[j][i]);
			}
		}
	}
	
	/**
	 * This function sets the icons on the squares to be the correct piece.
	 */
	private void setUpPieces() {
		try {
			for(int x = 0; x < 8; x++) {
				boardSquares[x][1].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Wh0bjHJ.png"))));
				boardSquares[x][6].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/KBCho1t.png"))));
			}
			
			boardSquares[0][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/bXj2hIk.png"))));
			boardSquares[1][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/WGyP3ZJ.png"))));
			boardSquares[2][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/SDO49Yf.png"))));
			boardSquares[3][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ppZjkwq.png"))));
			boardSquares[4][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Z5ai3Lt.png"))));
			boardSquares[5][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/SDO49Yf.png"))));
			boardSquares[6][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/WGyP3ZJ.png"))));
			boardSquares[7][0].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/bXj2hIk.png"))));
			
			boardSquares[0][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/SgJg9cF.png"))));
			boardSquares[1][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ABfZ2ZL.png"))));
			boardSquares[2][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/DSTdYbt.png"))));
			boardSquares[3][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/rAZsKP2.png"))));
			boardSquares[4][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/KMKXc9M.png"))));
			boardSquares[5][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/DSTdYbt.png"))));
			boardSquares[6][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ABfZ2ZL.png"))));
			boardSquares[7][7].setIcon(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/SgJg9cF.png"))));	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * The main method of the GUI.
     * 
     * @param args
     */
    public static void main(String[] args) {
    	new GUI();
    }
}
