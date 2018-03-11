package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Board.GUI;

class GUITests {

	@Test
	void runGUI() {
		GUI gui = new GUI();
		assertNotNull(gui);
	}

}
