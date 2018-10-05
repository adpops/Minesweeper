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
		//These 4 for loops go through the 8 squares surrounding the clicked tile and see if they are 
		for(int i = -1; i <= 1; i+=2)
		{
			potTile = tileList[tile.getTileX() + i][tile.getTileY()];
			removeCoverOrAddCount();
		}
		
		for(int i = -1; i <= 1; i+=2)
		{
			potTile = tileList[tile.getTileX()][tile.getTileY() + i];
			removeCoverOrAddCount();
		}
		
		for(int i = -1; i <= 1; i+=2)
		{
			potTile = tileList[tile.getTileX() + i][tile.getTileY() + i];
			removeCoverOrAddCount();
		}
		
		for(int i = -1; i <= 1; i+=2)
		{
			potTile = tileList[tile.getTileX() - i][tile.getTileY() + i];
			removeCoverOrAddCount();
		}
		
		tile.setNum(surroundingMines);
	}
	
	private void removeCoverOrAddCount()
	{
		if(potTile.getHasMine())
		{
			potTile.removeImage(COVER);
	    	potTile.setAlive(false);
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
	
	
}
