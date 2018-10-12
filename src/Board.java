import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

//This class will create the gameboard
public class Board extends JPanel
{
	private Tile tileList[][];
	private int width;
	private int height;
	private int mines;
	private int surroundingMines;
	
	private Tile potTile;
	
	private final int COVER = 0;
	private final int NUMBER = 1;
	private final int FLAG = 2;
	private final int QUESTION = 3;
	private final int MINE = 4;
	
	public Board(int width, int height, int mines)
	{
		this.width = width;
		this.height = height;
		this.mines = mines;
		setLayout(new GridLayout(width, height));
		
		tileList = new Tile[width][height];
		
		createBoard();
	}
	
	private void createBoard()
	{
		Random rand = new Random(64);
		Tile tile;
		boolean hasMine = false;
		rand = new Random(64);

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{	
				if(rand.nextInt() <= mines)
				{
					hasMine = true;
				}
				tile = new Tile(hasMine, x, y, this);
				
	            this.add(tile);
	            tileList[x][y] = tile;
	            hasMine = false;
			}
		}
	}
	
	public void tileCheck(Tile tile) 
	{
		int potX = 0;
		int potY = 0;
		
			//These 4 for loops go through the 8 squares surrounding the clicked tile and see if they are 
			for(int i = -1; i <= 1; i+=2)
			{
				potX = tile.getTileX() + i;
				potY = tile.getTileY();
				checkPotXAndY(potX, potY);
			}
			
			for(int i = -1; i <= 1; i+=2)
			{
				potX = tile.getTileX();
				potY = tile.getTileY() + i;
				checkPotXAndY(potX, potY);
			}
			
			for(int i = -1; i <= 1; i+=2)
			{
				potX = tile.getTileX() + i;
				potY = tile.getTileY() + i;
				checkPotXAndY(potX, potY);
			}
			
			for(int i = -1; i <= 1; i+=2)
			{
				potX = tile.getTileX() - i;
				potY = tile.getTileY() + i;
				checkPotXAndY(potX, potY);
			}
			
			tile.setNum(surroundingMines);
	}
	
	private void removeCoverOrAddCount()
	{
		if(true /*potTile.getHasMine()*/)
		{
			//potTile.removeImage(COVER);
			
	    	potTile.setAlive(false);
	    	System.out.println(potTile);
		}
		else
		{
			surroundingMines++;
		}
	}
	public Tile[][] getTileList()
	{
		return tileList;
	}
	
	private void checkPotXAndY(int x, int y)
	{
		if(x < 8 && y < 8)
		{
			potTile = tileList[x][y];
			removeCoverOrAddCount();
		}
	}
	
	
}
