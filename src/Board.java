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
	
	public Board(int width, int height, int mines)
	{
		this.width = width;
		this.height = height;
		this.mines = mines;
		this.setLayout(new GridLayout(width, height));
		
		tileList = new Tile[width][height];
		
		createBoard();
	}
	
	private void createBoard()
	{
		Random rand = new Random();
		Tile tile;
		int number = 0;
		
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				tile = new Tile(number, x, y, this);
	            this.add(tile);
	            tileList[x][y] = tile;
			}
		}
	}
	
	public Tile[][] getTileList()
	{
		return tileList;
	}
	
	
}
