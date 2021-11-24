import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel {
    private JLabel coverLbl;
    private JLabel flagLbl;
    private JLabel questionLbl;
    private JLabel mineLbl;
    private JLabel numLbl;

    private Listener listener;
    private boolean alive;
    private int x;
    private int y;
    private int iconType;
    private int tileNum = 0;
    BoardPanel board;

    private final int COVER = 0;
    private final int NUMBER = 1;
    private final int FLAG = 2;
    private final int QUESTION = 3;
    private final int MINE = 4;

    // Class for each of the tiles on gameboard
    public Tile(int x, int y, BoardPanel board) {

	setLayout(new BorderLayout());

	/*
	 * Coordinates will start from top left at (0, 0) and then next tiles will be
	 * (0, 1) and (1, 0) down to the last tile
	 */
	this.board = board;
	this.x = x;
	this.y = y;

	coverLbl = new JLabel(new ImageIcon(getImageForTile(COVER)));
	this.add(coverLbl);

	// Flag image
	flagLbl = new JLabel(new ImageIcon(getImageForTile(FLAG)));

	// Question image
	questionLbl = new JLabel(new ImageIcon(getImageForTile(QUESTION)));

	// Mine image
	mineLbl = new JLabel(new ImageIcon(getImageForTile(MINE)));

	/*
	 * each tile needs it's own listener, that way I know which tile is being
	 * clicked on
	 */
	listener = new Listener(this, board);
	this.addMouseListener(listener);

	// board.tileCheck(this);
    }

    public int getNum() {
	return tileNum;
    }

    public int getTileX() {
	return x;
    }

    public int getTileY() {
	return y;
    }

    public boolean getAlive() {
	return alive;
    }

    public int getIconType() {
	return iconType;
    }

    public void setNum(int number) {
	tileNum = number;
    }

    public void addNum(int number) {
	tileNum += number;
	numLbl = new JLabel(new ImageIcon(getImageForTile(NUMBER)));
    }

    public void setAlive(boolean mode) {
	alive = mode;
	if(!mode) {
	    board.deadTiles++;
	}
    }

    public void setIconType(int icon) {
	iconType = icon;
    }

    private String determineNum(int num) {
	String filename = "";
	switch(num) {
	    case 1:
		filename = "One";
		break;
	    case 2:
		filename = "Two";
		break;
	    case 3:
		filename = "Three";
		break;
	    case 4:
		filename = "Four";
		break;
	    case 5:
		filename = "Five";
		break;
	    case 6:
		filename = "Six";
		break;
	    case 7:
		filename = "Seven";
		break;
	    case 8:
		filename = "Eight";
		break;
	}
	return filename;
    }

    private Image getImageForTile(int type) {
	String filename = "";

	switch(type) {
	    case COVER:
		filename = "Cover";
		break;
	    case NUMBER:
		filename = determineNum(tileNum);
		break;
	    case FLAG:
		filename = "Flag";
		break;
	    case QUESTION:
		filename = "Question";
		break;
	    case MINE:
		filename = "Mine";
		break;
	}
	filename += ".png";

	URL urlPieceImg = getClass().getResource("images/" + filename);
	return new ImageIcon(urlPieceImg).getImage();
    }

    public void removeImage(int type) {
	JLabel imageLbl = null;
	switch(type) {
	    case COVER:
		imageLbl = coverLbl;
		break;
	    case NUMBER:
		imageLbl = numLbl;
		break;
	    case FLAG:
		imageLbl = flagLbl;
		break;
	    case QUESTION:
		imageLbl = questionLbl;
		break;
	    case MINE:
		imageLbl = mineLbl;
		break;
	}
	this.remove(imageLbl);
	this.repaint();
    }

    public void placeImageOnTile(int type) {
	JLabel imageLbl = null;

	switch(type) {
	    case COVER:
		imageLbl = coverLbl;
		setIconType(COVER);
		break;
	    case NUMBER:
		imageLbl = numLbl;
		setIconType(NUMBER);
		break;
	    case FLAG:
		imageLbl = flagLbl;
		setIconType(FLAG);
		break;
	    case QUESTION:
		imageLbl = questionLbl;
		setIconType(QUESTION);
		break;
	    case MINE:
		imageLbl = mineLbl;
		setIconType(MINE);
		break;
	}
	this.add(imageLbl);
	imageLbl.revalidate();
	imageLbl.repaint();
    }
}