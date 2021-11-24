import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    BoardPanel boardPanel;
    private int width;
    private int height;
    private int difficulty;
    private int numOfMines;

    public GameFrame(GUIManager gui) {
	difficulty = gui.getDifficulty();
	decideBoardDimensions();
	createFrame();
	boardPanel = new BoardPanel(gui, this);

	pack();
	this.setVisible(true);
    }

    private void createFrame() {
	int tilePixelLength = 40;
	setPreferredSize(new Dimension(height * tilePixelLength, width * tilePixelLength));
	this.setResizable(false);
	this.setLayout(new BorderLayout());
    }

    private void decideBoardDimensions() {
	switch (difficulty) {
	    case 0:
		width = 8;
		height = 8;
		numOfMines = 10;
		break;
	    case 1:
		width = 16;
		height = 16;
		numOfMines = 40;
		break;
	    case 2:
		width = 16;
		height = 30;
		numOfMines = 40;
		break;
	}
    }

    public int getTileWidth() {
	return width;
    }

    public int getTileHeight() {
	return height;
    }

    public int getNumOfMines() {
	return numOfMines;
    }
}
