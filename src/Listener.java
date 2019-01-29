import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Listener implements MouseListener
{
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

	
    public Listener(Tile tile) 
    {
    	this.tile = tile;
        //this.num = tile.getNum();
        tile.setAlive(true);
		this.alive = tile.getAlive();
    }

	@Override 
    public void mousePressed(MouseEvent evt) 
    {
    	alive = tile.getAlive();
    	if(alive) //If the tile has already been clicked, don't do anything
    	{
    		if(SwingUtilities.isLeftMouseButton(evt)) //If Left Click
    		{
        		if(num != -1) //If it contains a mine, game over
            	{
        			tile.setAlive(false); //sets it so program knows that tile has been clicked before
        			tile.removeImage(COVER);
        			
            		if(num != 0)
            		{
            			//tile.placeImageOnTile(NUMBER);
            		}
            	}
            	else //Game Over Method should be added here
            	{
    				tile.removeImage(COVER);
        			//tile.placeImageOnTile(MINE);
            	}
		    	tile.setAlive(false);
        	}
    		else if(SwingUtilities.isRightMouseButton(evt)) //If right click
        	{
        		switch(tile.getIconType())
        		{
    				case COVER:
    					//tile.placeImageOnTile(FLAG);
    					break;
    				case FLAG:
    					tile.removeImage(FLAG);
    					//tile.placeImageOnTile(QUESTION);
    					break;  
    				case QUESTION:
    					tile.removeImage(QUESTION);
    					break;  
        		}
        	}
    	}
    	
    }
	
    @Override
    public void mouseClicked(MouseEvent arg0){}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
