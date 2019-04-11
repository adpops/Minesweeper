import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel {
    private Cover cover;
    private Number num;
    private Flag flag;
    private ImageIcon coverImg;
    private ImageIcon numImg;
    private ImageIcon flagImg;
    private ImageIcon questionImg;
    private ImageIcon mineImg;

    private JLabel coverLbl;
    private JLabel flagLbl;
    private JLabel questionLbl;

    private Listener listener;
    private boolean alive;
    private int x;
    private int y;
    private int iconType;
    private BoardPanel board;
    private boolean hasMine;
    private int mineNumber;
    private int tileNum;

    private final int COVER = 0;
    private final int NUMBER = 1;
    private final int FLAG = 2;
    private final int QUESTION = 3;
    private final int MINE = 4;

    // Class for each of the tiles on gameboard
    public Tile(int x, int y, BoardPanel board) {

	// Coordinates will start from top left at (0, 0) and then next tiles will be
	// (0, 1) and (1, 0) down to the last tile
	this.x = x;
	this.y = y;
	this.board = board;
	hasMine = false;
	setLayout(new BorderLayout());

	coverImg = new ImageIcon(getImageForTile(COVER));
	coverLbl = new JLabel(coverImg);
	this.add(coverLbl);

	// Flag image
	flagImg = new ImageIcon(getImageForTile(FLAG));
	flagLbl = new JLabel(flagImg);

	// Question image
	questionImg = new ImageIcon(getImageForTile(QUESTION));
	questionLbl = new JLabel(questionImg);

	// each tile needs it's own listener, that way I know which tile is being
	// clicked on
	listener = new Listener(this);
	this.addMouseListener(listener);

	// Mine image code
	if (hasMine == true) {
	    /*
	     * mine = new Mine(); mineImg = mine.getImageIcon();
	     */
	}

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

    public boolean getHasMine() {
	return hasMine;
    }

    public void setMine() {
	hasMine = true;
    }

    public void setAlive(boolean mode) {
	alive = mode;
    }

    public void setIconType(int icon) {
	iconType = icon;
    }

    private Image getImageForTile(int type) {
	String filename = "";

	switch (type) {
	    case COVER:
		filename += "Cover";
		break;
	    case NUMBER:
		filename += "Number";
		break;
	    case FLAG:
		filename += "Flag";
		break;
	    case QUESTION:
		filename += "Question";
		break;
	    case MINE:
		filename += "Mine";
		break;
	}
	filename += ".png";

	URL urlPieceImg = getClass().getResource("images/" + filename);
	return new ImageIcon(urlPieceImg).getImage();
    }

    public void removeImage(int type) {
	JLabel imageLbl = null;
	switch (type) {
	    case COVER:
		imageLbl = coverLbl;
		break;
	    case NUMBER:
		imageLbl = new JLabel(numImg);
		break;
	    case FLAG:
		imageLbl = flagLbl;
		break;
	    case QUESTION:
		imageLbl = questionLbl;
		break;
	    case MINE:
		imageLbl = new JLabel(mineImg);
		break;
	}
	this.remove(imageLbl);
	this.repaint();

    }

    public void placeImageOnTile(int type) {
	JLabel imageLbl = null;

	switch (type) {
	    case COVER:
		imageLbl = coverLbl;
		setIconType(COVER);
		break;
	    case NUMBER:
		imageLbl = new JLabel(numImg);
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
		imageLbl = new JLabel(mineImg);
		setIconType(MINE);
		break;
	}

	this.add(imageLbl);
	imageLbl.revalidate();
    }
}