import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Listener implements MouseListener
{
	private boolean alive;
	private Tile tile;
	private boolean containsMine;
	private int num;
	private Tile tileList[][];
	private Tile potTile;
	
	private final int COVER = 0;
	private final int NUMBER = 1;
	private final int FLAG = 2;
	private final int QUESTION = 3;
	private final int MINE = 4;

	
    public Listener(Tile tile, Board board) 
    {
    	this.tile = tile;
        this.containsMine = tile.getContainsMine();
        this.num = tile.getNum();
        tile.setAlive(true);
		tileList = board.getTileList();
		this.alive = tile.getAlive();
    }

	@Override 
    public void mousePressed(MouseEvent evt) 
    {
    	alive = tile.getAlive();
    	if(alive) //If the tile has already been clicked, don't do anything
    	{
    		if(SwingUtilities.isLeftMouseButton(evt))
    		{
        		if(!containsMine) //If it contains a mine, game over
            	{
        			tile.setAlive(false); //sets it so program knows that tile has been clicked before
            		if(num != 0 && num != -1)
            		{
            			tile.placeImageOnTile(NUMBER);
            		}
            		
            		//These 4 for loops go through the 8 squares surrounding the clicked tile and see if they are 
            		for(int i = -1; i <= 1; i+=2)
            		{
            			potTile = tileList[tile.getX() + i][tile.getY()];
            			if(potTile.getNum() == 0)
            			{
            				potTile.removeImage(COVER);
            		    	potTile.setAlive(potTile.getAlive());
            			}
            		}
            		
            		for(int i = -1; i <= 1; i+=2)
            		{
            			potTile = tileList[tile.getX()][tile.getY() + i];
            			if(potTile.getNum() == 0)
            			{
            				potTile.removeImage(COVER);
            		    	potTile.setAlive(potTile.getAlive());
            			}
            		}
            		
            		for(int i = -1; i <= 1; i+=2)
            		{
            			potTile = tileList[tile.getX() + i][tile.getY() + i];
            			if(potTile.getNum() == 0)
            			{
            				potTile.removeImage(COVER);
            		    	potTile.setAlive(potTile.getAlive());
            			}
            		}
            		
            		for(int i = -1; i <= 1; i+=2)
            		{
            			potTile = tileList[tile.getX() - i][tile.getY() + i];
            			if(potTile.getNum() == 0)
            			{
            				potTile.removeImage(COVER);
            		    	potTile.setAlive(potTile.getAlive());
            			}
            		}
            	}
            	else //Game Over Method should be added here
            	{
        			tile.placeImageOnTile(MINE);
            	}
        	}
    		else //If right click
        	{
        		switch(tile.getIconType())
        		{
    	    		
    				case COVER:
    					tile.placeImageOnTile(FLAG);
    					break;
    				case FLAG:
    					tile.placeImageOnTile(QUESTION);
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
