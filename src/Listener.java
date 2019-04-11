import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Listener implements MouseListener {
    private boolean alive;
    private Tile tile;
    private int num;
    private Tile tileList[][];
    private Tile potTile;

    private final int COVER = 0;
    private final int NUMBER = 1;
    private final int FLAG = 2;
    private final int QUESTION = 3;
    private final int MINE = 4;

    public Listener(Tile tile) {
	this.tile = tile;
	// this.num = tile.getNum();
	tile.setAlive(true);
	this.alive = tile.getAlive();
    }

    @Override
    public void mousePressed(MouseEvent evt) {
	alive = tile.getAlive();

	if (SwingUtilities.isLeftMouseButton(evt)) // If Left Click
	{
	    // If it contains a mine, game over
	    if (num != -1) {
		if (alive) {
		    tile.removeImage(COVER);
		}
		tile.setAlive(false); // sets it so program knows that tile has been clicked before

		if (num != 0) {
		    // tile.placeImageOnTile(NUMBER);
		}
	    }
	    // Game Over Method should be added here
	    else {
		tile.remove(COVER);
		tile.placeImageOnTile(MINE);
	    }
	    tile.setAlive(false);
	}
	// If right click
	else if (SwingUtilities.isRightMouseButton(evt)) {

	    switch (tile.getIconType()) {
		case COVER:
		    tile.removeImage(COVER);
		    tile.placeImageOnTile(FLAG);
		    break;
		case FLAG:
		    tile.removeImage(FLAG);
		    tile.placeImageOnTile(QUESTION);
		    break;
		case QUESTION:
		    tile.removeImage(QUESTION);
		    tile.placeImageOnTile(COVER);
		    break;
	    }
	}
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
}
