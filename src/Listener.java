import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Listener implements MouseListener {
    private boolean alive;
    private Tile tile;
    private BoardPanel board;

    private final int COVER = 0;
    private final int NUMBER = 1;
    private final int FLAG = 2;
    private final int QUESTION = 3;
    private final int MINE = 4;

    public Listener(Tile tile, BoardPanel board) {
	this.tile = tile;
	this.board = board;
	tile.setAlive(true);
	this.alive = tile.getAlive();
    }

    @Override
    public void mousePressed(MouseEvent evt) {
	alive = tile.getAlive();
	// If Left Click
	if(SwingUtilities.isLeftMouseButton(evt) && tile.getIconType() == COVER && alive) {
	    tile.removeImage(COVER); // If it contains a mine, game over

	    if(tile.getNum() > 0) {
		tile.setAlive(false); // sets it so program knows that tile has been clicked before
		tile.placeImageOnTile(NUMBER);
	    }
	    else if(tile.getNum() == 0) {
		board.clearTiles(tile.getTileX(), tile.getTileY(), COVER);
	    }
	    // Game Over Method should be added here
	    else if(tile.getNum() == -1) {
		tile.placeImageOnTile(MINE);
		board.gameOver();
	    }
	    board.checkIfTilesLeft();
	}
	// If right click
	else if(SwingUtilities.isRightMouseButton(evt)) {

	    switch(tile.getIconType()) {
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
